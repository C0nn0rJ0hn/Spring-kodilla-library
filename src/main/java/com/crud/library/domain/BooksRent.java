package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Books_Rent")
public class BooksRent
{
    @Id
    @NotNull
    @GeneratedValue
    private Long id;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "start_rent_date")
    private LocalDate startRentDate;

    private Readers reader;

    private Books book;

    public BooksRent(LocalDate returnDate, LocalDate startRentDate) {
        this.returnDate = returnDate;
        this.startRentDate = startRentDate;
    }
}
