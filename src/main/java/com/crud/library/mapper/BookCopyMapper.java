package com.crud.library.mapper;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.BookCopyDto;
import com.crud.library.domain.Rent;
import com.crud.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCopyMapper
{
    @Autowired
    private BookRepository repository;


    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy)
    {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getBook().getId(),
                bookCopy.getStatus(),
                bookCopy.getRentedBookCopiesList().stream().map(Rent::getId).collect(Collectors.toList())
        );
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto)
    {
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getStatus(),
                repository.findById(bookCopyDto.getBookId()).get()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookCopyList)
    {
        return bookCopyList.stream()
                .map(this::mapToBookCopyDto)
                .collect(Collectors.toList());
    }
}
