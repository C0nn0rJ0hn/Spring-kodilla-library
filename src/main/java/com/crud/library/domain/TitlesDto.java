package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TitlesDto
{
    private Long id;
    private String author;
    private String title;
    private int publishYear;
}
