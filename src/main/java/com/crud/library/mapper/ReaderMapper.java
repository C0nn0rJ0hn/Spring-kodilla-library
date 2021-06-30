package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import com.crud.library.domain.Rent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper
{
    public Reader mapToReader(final ReaderDto readerDto)
    {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getAccountCreationDate()
        );

    }

    public ReaderDto mapToReaderDto(final Reader reader)
    {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getAccountCreationDate(),
                reader.getRentListReader().stream().map(Rent::getId).collect(Collectors.toList())
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList)
    {
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
