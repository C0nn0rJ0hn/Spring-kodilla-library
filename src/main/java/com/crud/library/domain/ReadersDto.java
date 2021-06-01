package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReadersDto
{
    private Long id;
    private String name;
    private String surname;
    private LocalDate accountCreationDate;
}
