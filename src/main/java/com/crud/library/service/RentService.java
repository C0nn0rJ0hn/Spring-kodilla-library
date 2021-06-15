package com.crud.library.service;


import com.crud.library.domain.Rent;
import com.crud.library.domain.RentalStatus;
import com.crud.library.repository.RentRepository;
import com.crud.library.repository.BookCopyRepository;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentService
{
    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public List<Rent> getAllRentedBooks()
    {
        return rentRepository.findAll();
    }

    public Rent rentBook(Rent rentedBook)
    {
        rentedBook.getBookCopy().setStatus(RentalStatus.RENTED);
        rentedBook.setStartRentDate(LocalDate.now().minusDays(15));
        bookCopyRepository.save(rentedBook.getBookCopy());
        return rentRepository.save(rentedBook);
    }

    public void returnBook(Long rentedBookId)
    {
        Optional<Rent> rentedBook = rentRepository.findById(rentedBookId);
        Rent returnedBook = rentedBook.get();
        returnedBook.getBookCopy().setStatus(RentalStatus.AVAILABLE);
        rentedBook.get().setReturnDate(LocalDate.now());
        bookCopyRepository.save(returnedBook.getBookCopy());
        rentRepository.save(returnedBook);
    }

    public void deleteRentBookById(Long rentedBookId)
    {
        rentRepository.deleteById(rentedBookId);
    }
}
