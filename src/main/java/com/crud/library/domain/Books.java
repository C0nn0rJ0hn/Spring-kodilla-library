package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "BOOK_COPIES")
public class Books
{
    @Id
    @GeneratedValue
    @Column(name = "BOOK_COPY_ID")
    private Long id;

    @Column(name = "STATUS", columnDefinition = "enum('AVAILABLE', 'DESTROYED', 'LOST', 'RENTED')")
    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @ManyToOne
    @JoinColumn(name = "BOOK_TITLE_ID")
    private Titles title;

    @OneToMany(
            targetEntity = BooksRent.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BooksRent> booksRentList = new ArrayList<>();

    public Books(Long id, RentalStatus status, Titles title) {
        this.id = id;
        this.status = status;
        this.title = title;
    }
}
