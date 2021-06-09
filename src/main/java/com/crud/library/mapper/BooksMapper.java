package com.crud.library.mapper;

import com.crud.library.domain.Books;
import com.crud.library.domain.BooksDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksMapper
{
    public BooksDto mapToBooksDto(Books book)
    {
        return new BooksDto(
                book.getId(),
                book.getStatus(),
                book.getTitle()
        );
    }

    public Books mapToBooks(BooksDto bookDto)
    {
        return new Books(
                bookDto.getId(),
                bookDto.getStatus(),
                bookDto.getTitle()
        );
    }

    public List<BooksDto> mapToBooksDtoList(List<Books> booksList)
    {
        return booksList.stream()
                .map(this::mapToBooksDto)
                .collect(Collectors.toList());
    }
}
