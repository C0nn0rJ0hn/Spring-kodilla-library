package com.crud.library.controller;

import com.crud.library.domain.Books;
import com.crud.library.domain.BooksDto;
import com.crud.library.domain.RentalStatus;
import com.crud.library.exceptions.NoBookCopyFoundException;
import com.crud.library.mapper.BooksMapper;
import com.crud.library.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/library/bookCopies")
public class BooksController
{
    private final BooksMapper mapper;
    private final BooksService service;

    @GetMapping(value = "/getBookCopies")
    public List<BooksDto> getBookCopies()
    {
        List<Books> bookCopiesList = service.getAllBookCopies();
        return mapper.mapToBooksDtoList(bookCopiesList);
    }

    @PostMapping(value = "/addNewCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewCopyOfBook(@RequestBody BooksDto booksDto)
    {
        Books book = mapper.mapToBooks(booksDto);
        service.addBookCopy(book);
    }

    @PutMapping(value = "/updateBookCopyStatus")
    public void updateStatus(@RequestParam Long bookCopyId, @RequestParam RentalStatus status)
    {
        service.updateBookCopyStatus(bookCopyId, status);
    }

    @GetMapping(value = "/getBookCopyById")
    public BooksDto getBookCopyById(@RequestParam Long bookCopyId) throws NoBookCopyFoundException
    {
        return mapper.mapToBooksDto(service.getBookCopyById(bookCopyId).orElseThrow(NoBookCopyFoundException::new));
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
