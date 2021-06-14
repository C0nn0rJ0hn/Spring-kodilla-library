package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentDto
{
    private Long id;
    private Long readerId;
    private Long bookCopyId;
    private LocalDate startRentDate;
    private LocalDate returnDate;
}
