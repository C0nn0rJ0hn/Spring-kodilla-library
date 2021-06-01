package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "BOOKS_RENTAL")
public class BooksRent
{
    @Id
    @NotNull
    @GeneratedValue
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

    public BooksRent(int startYear, int startMonth, int startDay, int returnYear, int returnMonth, int returnDay) {
        this.returnDate = LocalDate.of(returnYear, returnMonth, returnDay);
        this.startRentDate = LocalDate.of(startYear, startMonth, startDay);
    }
}
