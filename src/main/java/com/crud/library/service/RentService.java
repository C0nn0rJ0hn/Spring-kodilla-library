package com.crud.library.service;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.Rent;
import com.crud.library.domain.RentalStatus;
import com.crud.library.repository.BookCopyRepository;
import com.crud.library.repository.RentRepository;
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

    public List<Rent> getAllRentedBookCopies()
    {
        return rentRepository.findAll();
    }

    public void deleteRentedBookCopyRecord(Long rentId)
    {
        rentRepository.deleteById(rentId);
    }

    public Rent rentBookCopy(final Rent rentedBookCopy)
    {
        BookCopy getRentedBook = rentedBookCopy.getBookCopy();
        getRentedBook.setStatus(RentalStatus.RENTED);
        bookCopyRepository.save(getRentedBook);
        return rentRepository.save(rentedBookCopy);
    }

    public void returnBookCopy(Long rentedBookCopyId)
    {
        Optional<Rent> rent = rentRepository.findById(rentedBookCopyId);
        Rent bookCopyToReturn = rent.get();
        bookCopyToReturn.getBookCopy().setStatus(RentalStatus.AVAILABLE);
        bookCopyRepository.save(bookCopyToReturn.getBookCopy());
        bookCopyToReturn.setReturnDate(LocalDate.now());
        rentRepository.save(bookCopyToReturn);
    }
}
