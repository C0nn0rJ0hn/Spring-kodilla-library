package com.crud.library.controller;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import com.crud.library.exceptions.ReaderNotFoundException;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/library/readers")
public class ReaderController
{

    private final ReaderMapper readerMapper;
    private final ReaderService readerService;

    @GetMapping(value = "getReaders")
    public List<ReaderDto> getReaders()
    {
        List<Reader> readerList = readerService.getAllReaders();
        return readerMapper.mapToReaderDtoList(readerList);
    }

    @GetMapping(value = "getReader")
    public ReaderDto getReader(@RequestParam Long readerId) throws ReaderNotFoundException
    {
        return readerMapper.mapToReaderDto(readerService.getReaderById(readerId).orElseThrow(ReaderNotFoundException::new));
    }

    @PostMapping(value = "addReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody ReaderDto readerDto)
    {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerService.addReader(reader);
    }

    @PutMapping(value = "updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto)
    {
        Reader reader = readerMapper.mapToReader(readerDto);
        Reader savedReader = readerService.addReader(reader);
        return readerMapper.mapToReaderDto(savedReader);
    }

    @DeleteMapping(value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId)
    {
        readerService.deleteReaderById(readerId);
    }
}
