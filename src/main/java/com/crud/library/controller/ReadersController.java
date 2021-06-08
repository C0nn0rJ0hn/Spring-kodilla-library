package com.crud.library.controller;

import com.crud.library.domain.Readers;
import com.crud.library.domain.ReadersDto;
import com.crud.library.exceptions.ReaderNotFoundException;
import com.crud.library.mapper.ReadersMapper;
import com.crud.library.service.ReadersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/library/readers")
public class ReadersController
{

    private final ReadersMapper readersMapper;
    private final ReadersService readersService;

    @GetMapping(value = "getReaders")
    public List<ReadersDto> getReaders()
    {
        List<Readers> readersList = readersService.getAllReaders();
        return readersMapper.mapToReadersDtoList(readersList);
    }

    @GetMapping(value = "getReader")
    public ReadersDto getReader(@RequestParam Long readerId) throws ReaderNotFoundException
    {
        return readersMapper.mapToReadersDto(readersService.getReaderById(readerId).orElseThrow(ReaderNotFoundException::new));
    }

    @PostMapping(value = "addReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody ReadersDto readersDto)
    {
        Readers reader = readersMapper.mapToReaders(readersDto);
        readersService.addReader(reader);
    }

    @PutMapping(value = "updateReader")
    public ReadersDto updateReader(@RequestBody ReadersDto readersDto)
    {
        Readers reader = readersMapper.mapToReaders(readersDto);
        Readers savedReader = readersService.addReader(reader);
        return readersMapper.mapToReadersDto(savedReader);
    }

    @DeleteMapping(value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId)
    {
        readersService.deleteReaderById(readerId);
    }
}
