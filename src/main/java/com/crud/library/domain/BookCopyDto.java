package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BookCopyDto
{
    private Long id;
    private Long bookId;
    private RentalStatus status;
    private List<Long> rentedBookCopy;
}
