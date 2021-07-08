package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class BookCopyDto
{
    private Long id;
    private Long bookId;
    private RentalStatus status;
    private List<Long> rentedBookCopy = new ArrayList<>();
}
