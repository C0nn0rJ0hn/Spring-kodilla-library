package com.crud.library.mapper;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.BookCopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCopyMapper
{
    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy)
    {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getStatus(),
                bookCopy.getBook(),
                bookCopy.getRent()
        );
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto)
    {
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getStatus(),
                bookCopyDto.getBook(),
                bookCopyDto.getRent()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookCopyList)
    {
        return bookCopyList.stream()
                .map(this::mapToBookCopyDto)
                .collect(Collectors.toList());
    }
}
