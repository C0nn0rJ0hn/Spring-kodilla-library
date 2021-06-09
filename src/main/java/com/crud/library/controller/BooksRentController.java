package com.crud.library.controller;

import com.crud.library.domain.BooksRent;
import com.crud.library.domain.BooksRentDto;
import com.crud.library.mapper.BooksRentMapper;
import com.crud.library.service.BooksRentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/v1/library/rent")
public class BooksRentController {

    @Autowired
    private BooksRentService service;

    @Autowired
    private BooksRentMapper mapper;

    @GetMapping(value = "/getRentedBooks")
    public List<BooksRentDto> getRentedBooks()
    {
        return mapper.mapToBooksRentDtoList(service.getAllRentedBooks());
    }

    @PostMapping(value = "/rentBook")
    public BooksRentDto rentBook(@RequestBody BooksRentDto booksRentDto)
    {
        BooksRent bookToRent = mapper.mapToBooksRent(booksRentDto);
        BooksRent saveRentedBook = service.rentBook(bookToRent);
        return mapper.mapToBooksRentDto(saveRentedBook);
    }

    @PutMapping(value = "/returnBook")
    public void returnBook(@RequestParam Long rentedBookId)
    {
        service.returnBook(rentedBookId);
    }

}
