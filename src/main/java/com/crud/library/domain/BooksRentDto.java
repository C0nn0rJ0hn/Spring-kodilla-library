package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BooksRentDto
{
    private Long id;
    private LocalDate returnDate;
    private LocalDate startRentDate;
    private Readers reader;
    private Books book;
    //private ReadersDto readerDto;
    //private BooksDto bookDto;
}
