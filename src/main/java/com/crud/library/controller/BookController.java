package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import com.crud.library.exceptions.TitleNotFoundException;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/library/books")
public class BookController
{
    private final BookMapper mapper;
    private final BookService service;

    @GetMapping(value = "/getBooks")
    public List<BookDto> getTitles()
    {
        List<Book> bookList = service.getAllBooks();
        return mapper.mapToBookDtoList(bookList);
    }

    @GetMapping(value = "/getBook")
    public BookDto getBookById(@RequestParam Long bookId) throws TitleNotFoundException
    {
        return mapper.mapToBookDto(service.getBookById(bookId).orElseThrow(TitleNotFoundException::new));
    }

    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto)
    {
        service.addBook(mapper.mapToBook(bookDto));
    }

    @DeleteMapping(value = "/deleteBook")
    public void deleteTitle(@RequestParam Long bookId)
    {
        service.deleteBookById(bookId);
    }

    @PutMapping(value = "/updateBook")
    public BookDto updateTitle(@RequestBody BookDto bookDto)
    {
        Book book = mapper.mapToBook(bookDto);
        Book savedBook = service.addBook(book);
        return mapper.mapToBookDto(savedBook);
    }

    @GetMapping(value = "getBooksByYear")
    public List<BookDto> getBooksByPublishYear(@RequestParam int year)
    {
        List<Book> booksListByYear = service.getBookByPublishYear(year);
        return mapper.mapToBookDtoList(booksListByYear);
    }
}
