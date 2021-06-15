package com.crud.library.service;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.RentalStatus;
import com.crud.library.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookCopyService
{
    @Autowired
    private BookCopyRepository bookCopyRepository;

    public BookCopy addBookCopy(BookCopy book)
    {
        return bookCopyRepository.save(book);
    }

    public List<BookCopy> getAllBookCopies()
    {
        return bookCopyRepository.findAll();
    }

    public Optional<BookCopy> getBookCopyById(Long bookId)
    {
        return bookCopyRepository.findById(bookId);
    }

    public void deleteBookCopyById(Long bookId)
    {
        bookCopyRepository.deleteById(bookId);
    }

    public void updateBookCopyStatus(Long id, RentalStatus status)
    {
        Optional<BookCopy> bookCopy = bookCopyRepository.findById(id);
        BookCopy changedStatus = bookCopy.get();
        changedStatus.setStatus(status);
        bookCopyRepository.save(changedStatus);
    }

    public int bookCopiesAvailableToRent(String title)
    {
        return (int) bookCopyRepository.findAll().stream()
                .filter(t -> t.getBook().getTitle().equals(title))
                .filter(t -> t.getStatus().equals(RentalStatus.AVAILABLE))
                .count();
    }

}
