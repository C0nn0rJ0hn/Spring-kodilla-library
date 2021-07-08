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
public class BookCopy
{
    @Id
    @GeneratedValue
    @Column(name = "BOOK_COPY_ID")
    private Long id;

    @Column(name = "STATUS", columnDefinition = "enum('AVAILABLE', 'DESTROYED', 'LOST', 'RENTED')")
    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "bookCopy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rent> rentedBookCopiesList = new ArrayList<>();

    public BookCopy(Long id, RentalStatus status, Book book) {
        this.id = id;
        this.status = status;
        this.book = book;
    }
}
