package com.crud.library.service;


import com.crud.library.domain.BooksRent;
import com.crud.library.domain.RentalStatus;
import com.crud.library.repository.BooksRentRepository;
import com.crud.library.repository.BooksRepository;
import com.crud.library.repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BooksRentService
{
    @Autowired
    private BooksRentRepository booksRentRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ReadersRepository readersRepository;

    public List<BooksRent> getAllRentedBooks()
    {
        return booksRentRepository.findAll();
    }

    public BooksRent rentBook(BooksRent rentedBook)
    {
        rentedBook.getBook().setStatus(RentalStatus.RENTED);
        rentedBook.setStartRentDate(LocalDate.now().minusDays(15));
        booksRepository.save(rentedBook.getBook());
        return booksRentRepository.save(rentedBook);
    }

    public void returnBook(Long rentedBookId)
    {
        Optional<BooksRent> rentedBook = booksRentRepository.findById(rentedBookId);
        BooksRent returnedBook = rentedBook.get();
        returnedBook.getBook().setStatus(RentalStatus.AVAILABLE);
        rentedBook.get().setReturnDate(LocalDate.now());
        booksRepository.save(returnedBook.getBook());
        booksRentRepository.save(returnedBook);
    }
}
