package com.crud.library.mapper;

import com.crud.library.domain.Rent;
import com.crud.library.domain.RentDto;
import com.crud.library.repository.BookCopyRepository;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper
{
    @Autowired
    BookCopyRepository bookCopyRepository;

    @Autowired
    ReaderRepository readerRepository;

    public RentDto mapToRentDto(Rent rent)
    {
        return new RentDto(
                rent.getId(),
                rent.getReader().getId(),
                rent.getBookCopy().getId(),
                rent.getStartRentDate(),
                rent.getReturnDate()
        );
    }

    public Rent mapToRent(RentDto rentDto)
    {
        return  new Rent(
                rentDto.getId(),
                readerRepository.findById(rentDto.getReaderId()).get(),
                bookCopyRepository.findById(rentDto.getBookCopyId()).get(),
                rentDto.getStartRentDate(),
                rentDto.getReturnDate()
        );
    }

    public List<RentDto> mapToRentDtoList(List<Rent> rentList)
    {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
