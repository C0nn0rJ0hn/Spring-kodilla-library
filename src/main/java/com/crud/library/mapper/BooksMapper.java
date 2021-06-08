package com.crud.library.mapper;

import com.crud.library.domain.Books;
import com.crud.library.domain.BooksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksMapper
{
    @Autowired
    private TitlesMapper titlesMapper;

    public BooksDto mapToBooksDto(final Books books)
    {
        return new BooksDto(
                books.getId(),
                books.getStatus(),
                books.getBookTitle()
                //titlesMapper.mapToTitlesDto(books.getBookTitle())
        );
    }

    public Books mapToBooks(final BooksDto booksDto)
    {
        return new Books(
                booksDto.getId(),
                booksDto.getBookTitle(),
                booksDto.getStatus()
        );
    }

    public List<BooksDto> mapToBooksDtoList(final List<Books> booksList)
    {
        return booksList.stream()
                .map(this::mapToBooksDto)
                .collect(Collectors.toList());
    }
}
