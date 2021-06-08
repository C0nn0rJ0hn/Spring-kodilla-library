package com.crud.library.mapper;

import com.crud.library.domain.Readers;
import com.crud.library.domain.ReadersDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadersMapper
{
    public Readers mapToReaders(final ReadersDto readerDto)
    {
        return new Readers(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getAccountCreationDate()
        );

    }

    public ReadersDto mapToReadersDto(final Readers reader)
    {
        return new ReadersDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getAccountCreationDate(),
                reader.getBooksRentListByReader()
        );
    }

    public List<ReadersDto> mapToReadersDtoList(final List<Readers> readersList)
    {
        return readersList.stream()
                .map(this::mapToReadersDto)
                .collect(Collectors.toList());
    }
}
