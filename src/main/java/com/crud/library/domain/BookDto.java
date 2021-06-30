package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BookDto
{
    private Long id;
    private String author;
    private String title;
    private int publishYear;
    private List<Long> listBookCopy;
}
