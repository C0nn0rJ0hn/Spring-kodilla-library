package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto
{
    private Long id;
    private String name;
    private String surname;
    private LocalDate accountCreationDate;
    private List<Long> rentListByReader = new ArrayList<>();
}
