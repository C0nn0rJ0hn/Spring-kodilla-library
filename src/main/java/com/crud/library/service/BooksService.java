package com.crud.library.service;

import com.crud.library.domain.Books;
import com.crud.library.domain.RentalStatus;
import com.crud.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BooksService
{
    @Autowired
    private BooksRepository booksRepository;

    public Books addBookCopy(Books book)
    {
        return booksRepository.save(book);
    }

    public List<Books> getAllBookCopies()
    {
        return booksRepository.findAll();
    }

    public Optional<Books> getBookCopyById(Long bookId)
    {
        return booksRepository.findById(bookId);
    }

    public void deleteBookCopyById(Long bookId)
    {
        booksRepository.deleteById(bookId);
    }

    public void updateBookCopyStatus(Long id, RentalStatus status)
    {
        booksRepository.findById(id).get().setStatus(status);
    }

    public int bookCopiesAvailableToRent(String title)
    {
        return (int) booksRepository.findAll().stream()
                .filter(t -> t.getBookTitle().getTitle().equals(title))
                .filter(t -> t.getStatus().equals(RentalStatus.AVAILABLE))
                .count();
    }

}
