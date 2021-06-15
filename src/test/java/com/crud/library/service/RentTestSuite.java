package com.crud.library.service;

import com.crud.library.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class RentTestSuite
{
    @Autowired
    private RentService service;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCopyService bookCopyService;

    @Autowired
    private ReaderService readerService;

    @Test
    public void rentBookTest()
    {
        //Given
        Book book = new Book(null, "Title 1", "Author 1", 1999, null);
        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);
        Reader reader = new Reader(null, "Name", "Surname", LocalDate.of(1993, 06,30));
        Rent rentBook = new Rent(null, reader, bookCopy, null, null);
        readerService.addReader(reader);
        bookService.addBook(book);
        bookCopyService.addBookCopy(bookCopy);


        //When
        service.rentBook(rentBook);
        List<Rent> listOfRentedBooks = service.getAllRentedBooks();

        //Then
        Assertions.assertEquals(1, listOfRentedBooks.size());

        //Cleanup
        service.deleteRentBookById(rentBook.getId());
        bookService.deleteBookById(bookCopy.getId());
        bookService.deleteBookById(book.getId());
        readerService.deleteReaderById(reader.getId());
    }
}
