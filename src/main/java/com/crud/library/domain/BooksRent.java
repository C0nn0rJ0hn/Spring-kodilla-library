package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "BOOKS_RENTAL")
public class BooksRent
{
    @Id
    @GeneratedValue
    @Column(name = "BOOK_RENT_ID")
    private Long id;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @Column(name = "DATE_OF_RENT")
    private LocalDate startRentDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "READER_ID")
    private Readers reader;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COPY_OF_BOOK_ID")
    private Books book;

    public BooksRent(Long id, Readers reader, Books book, LocalDate startRentDate, LocalDate returnDate) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.startRentDate = startRentDate;
        this.returnDate = returnDate;
    }
}

