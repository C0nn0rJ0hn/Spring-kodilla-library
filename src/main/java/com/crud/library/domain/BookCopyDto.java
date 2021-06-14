package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookCopyDto
{
    private Long id;
    private RentalStatus status;
    private Book book;
    private Rent rent;
}
