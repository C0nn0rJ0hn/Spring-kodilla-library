package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BooksDto
{
    private Long id;
    private RentalStatus status;
    private Titles title;
}
