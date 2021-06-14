package com.crud.library.controller;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.BookCopyDto;
import com.crud.library.domain.RentalStatus;
import com.crud.library.exceptions.NoBookCopyFoundException;
import com.crud.library.mapper.BookCopyMapper;
import com.crud.library.service.BookCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/library/bookCopies")
public class BookCopyController
{
    private final BookCopyMapper mapper;
    private final BookCopyService service;

    @GetMapping(value = "/getBookCopies")
    public List<BookCopyDto> getBookCopies()
    {
        List<BookCopy> bookCopiesList = service.getAllBookCopies();
        return mapper.mapToBookCopyDtoList(bookCopiesList);
    }

    @PostMapping(value = "/addNewCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewCopyOfBook(@RequestBody BookCopyDto bookCopyDto)
    {
        BookCopy book = mapper.mapToBookCopy(bookCopyDto);
        service.addBookCopy(book);
    }

    @PutMapping(value = "/updateBookCopyStatus")
    public void updateStatus(@RequestParam Long bookCopyId, @RequestParam RentalStatus status)
    {
        service.updateBookCopyStatus(bookCopyId, status);
    }

    @GetMapping(value = "/getBookCopyById")
    public BookCopyDto getBookCopyById(@RequestParam Long bookCopyId) throws NoBookCopyFoundException
    {
        return mapper.mapToBookCopyDto(service.getBookCopyById(bookCopyId).orElseThrow(NoBookCopyFoundException::new));
    }

    @DeleteMapping(value = "/deleteBookCopy")
    public void deleteBookCopy(@RequestParam Long bookCopyId)
    {
        service.deleteBookCopyById(bookCopyId);
    }

    @GetMapping(value = "/countAvailableCopies")
    public int countAvailableCopies(@RequestParam String title)
    {
        return service.bookCopiesAvailableToRent(title);
    }


}
