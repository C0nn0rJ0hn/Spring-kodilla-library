package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper
{
    public Book mapToBook(final BookDto bookDto)
    {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublishYear(),
                bookDto.getListBookCopy()
        );
    }

    public BookDto mapToBookDto(final Book book)
    {
        return new BookDto(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getPublishYear(),
                book.getBookCopyList()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList)
    {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
