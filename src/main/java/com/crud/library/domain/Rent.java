package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Reader reader;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_COPY_ID")
    @JsonBackReference
    private BookCopy bookCopy;

    public Rent(Long id, Reader reader, BookCopy bookCopy, LocalDate startRentDate, LocalDate returnDate) {
        this.id = id;
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.startRentDate = startRentDate;
        this.returnDate = returnDate;
    }
}
