package com.crud.library.controller;

import com.crud.library.domain.Rent;
import com.crud.library.domain.RentDto;
import com.crud.library.mapper.RentMapper;
import com.crud.library.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/v1/library/rent")
public class RentController {

    @Autowired
    private RentService service;

    @Autowired
    private RentMapper mapper;

    @GetMapping(value = "/getRentedBooks")
    public List<RentDto> getRentedBooks()
    {
        return mapper.mapToRentDtoList(service.getAllRentedBookCopies());
    }

    @PostMapping(value = "/rentBook")
    public RentDto rentBook(@RequestBody RentDto rentDto)
    {
        Rent rent = service.rentBookCopy(mapper.mapToRent(rentDto));
        return mapper.mapToRentDto(rent);
    }

    @PutMapping(value = "/returnBook")
    public void returnBook(@RequestParam Long rentedBookId)
    {
        service.returnBookCopy(rentedBookId);
    }

}
