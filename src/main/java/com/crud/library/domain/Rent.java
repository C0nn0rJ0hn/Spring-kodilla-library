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
public class Rent
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
    private Reader reader;

    @OneToOne
    @JoinColumn(name = "BOOK_COPY_ID")
    private BookCopy bookCopy;

    public Rent(Long id, Reader reader, BookCopy bookCopy, LocalDate startRentDate, LocalDate returnDate) {
        this.id = id;
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.startRentDate = startRentDate;
        this.returnDate = returnDate;
    }
}

