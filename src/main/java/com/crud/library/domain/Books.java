package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "BOOK_COPIES")
public class Books
{
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_TITLE_ID")
    private Titles bookTitle;

    public Books(Long id, Titles bookTitle, RentalStatus status) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.status = status;
    }

    @OneToMany(
            targetEntity = BooksRent.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BooksRent> booksRentList = new ArrayList<>();
}
