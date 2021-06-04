package com.crud.library.service;


import com.crud.library.domain.BooksRent;
import com.crud.library.domain.RentalStatus;
import com.crud.library.repository.BooksRentRepository;
import com.crud.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class BooksRentService
{
    @Autowired
    private BooksRentRepository booksRentRepository;

    @Autowired
    private BooksRepository booksRepository;

    public List<BooksRent> getAllRentedBooks()
    {
        return booksRentRepository.findAll();
    }

    public BooksRent rentBook(BooksRent rentedBook)
    {
        rentedBook.getBook().setStatus(RentalStatus.RENTED);
        rentedBook.setStartRentDate(LocalDate.now());
        booksRepository.save(rentedBook.getBook());
        return booksRentRepository.save(rentedBook);
    }

    public void returnBook(Long rentedBookId)
    {

    }
}
