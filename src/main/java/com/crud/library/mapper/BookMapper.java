package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookCopy;
import com.crud.library.domain.BookDto;
import com.crud.library.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookMapper
{
    @Autowired
    private BookCopyRepository bookCopyRepository;

    public Book mapToBook(final BookDto bookDto)
    {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublishYear(),
                bookDto.getListBookCopy().stream().map(bookCopyRepository::findById)
                        .map(Optional::get).collect(Collectors.toList())
        );
    }

    public BookDto mapToBookDto(final Book book)
    {
        return new BookDto(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getPublishYear(),
                book.getBookCopyList().stream().map(BookCopy::getId).collect(Collectors.toList())
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList)
    {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
