package com.crud.library.mapper;

import com.crud.library.domain.BooksRent;
import com.crud.library.domain.BooksRentDto;
import com.crud.library.repository.BooksRepository;
import com.crud.library.repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksRentMapper
{
    @Autowired
    BooksRepository booksRepository;

    @Autowired
    ReadersRepository readersRepository;

    public BooksRentDto mapToBooksRentDto(BooksRent booksRent)
    {
        return new BooksRentDto(
                booksRent.getId(),
                booksRent.getReader().getId(),
                booksRent.getBook().getId(),
                booksRent.getStartRentDate(),
                booksRent.getReturnDate()
        );
    }

    public BooksRent mapToBooksRent(BooksRentDto booksRentDto)
    {
        return  new BooksRent(
                booksRentDto.getId(),
                readersRepository.findById(booksRentDto.getReaderId()).get(),
                booksRepository.findById(booksRentDto.getBookCopyId()).get(),
                booksRentDto.getStartRentDate(),
                booksRentDto.getReturnDate()
        );
    }

    public List<BooksRentDto> mapToBooksRentDtoList(List<BooksRent> booksRentList)
    {
        return booksRentList.stream()
                .map(this::mapToBooksRentDto)
                .collect(Collectors.toList());
    }
}
