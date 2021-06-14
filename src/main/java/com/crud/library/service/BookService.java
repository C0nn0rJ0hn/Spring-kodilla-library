package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book)
    {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public void deleteBookById(final Long bookId)
    {
        bookRepository.deleteById(bookId);
    }

    public Optional<Book> getBookById(final Long bookId)
    {
        return bookRepository.findById(bookId);
    }

    public List<Book> getBookByPublishYear(final int publishYear)
    {
        return bookRepository.findByPublishYear(publishYear);
    }
}
