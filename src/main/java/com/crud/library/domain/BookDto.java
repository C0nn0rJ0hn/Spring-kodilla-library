package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto
{
    private Long id;
    private String author;
    private String title;
    private int publishYear;
    private List<Long> listBookCopy = new ArrayList<>();
}
