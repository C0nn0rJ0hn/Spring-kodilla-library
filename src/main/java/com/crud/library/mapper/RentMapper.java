package com.crud.library.mapper;

import com.crud.library.domain.Rent;
import com.crud.library.domain.RentDto;
import com.crud.library.repository.BookCopyRepository;
import com.crud.library.repository.ReaderRepository;
import com.crud.library.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper
{
    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    public Rent mapToRent(final RentDto rentDto)
    {
        return new Rent(
                rentDto.getId(),
                readerRepository.findById(rentDto.getReaderId()).get(),
                bookCopyRepository.findById(rentDto.getBookCopyId()).get(),
                rentDto.getStartRentDate(),
                rentDto.getReturnDate()
                );
    }

    public RentDto mapToRentDto(final Rent rent)
    {
        return new RentDto(
                rent.getId(),
                rent.getReader().getId(),
                rent.getBookCopy().getId(),
                rent.getStartRentDate(),
                rent.getReturnDate()
        );
    }

    public List<RentDto> mapToRentDtoList(final List<Rent> rentList)
    {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
