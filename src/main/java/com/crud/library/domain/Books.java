package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "TITLE_ID")
    private Titles title;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_RENT_ID")
    private BooksRent booksRent;
}
