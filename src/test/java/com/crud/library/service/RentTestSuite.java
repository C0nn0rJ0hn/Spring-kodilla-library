package com.crud.library.service;

import com.crud.library.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentTestSuite
{
    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCopyService bookCopyService;

    @Autowired
    private ReaderService readerService;

    @Test
    public void getAllRentedBookCopies()
    {
        //Given
        Reader reader = new Reader(null, "Name", "Surname", LocalDate.of(2021,6,29));
        readerService.addReader(reader);

        Book book = new Book(null, "Title", "Author", 2021, new ArrayList<>());
        bookService.addBook(book);

        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);
        bookCopyService.addBookCopy(bookCopy);

        Rent rent = new Rent(null, reader, bookCopy, LocalDate.now(), LocalDate.now().plusDays(30));
        rentService.rentBookCopy(rent);

        //When
        List<Rent> rentedBookCopies = rentService.getAllRentedBookCopies();

        //Then
        Assertions.assertEquals(1, rentedBookCopies.size());

        //Cleanup
        rentService.deleteRentedBookCopyRecord(rent.getId());
        bookCopyService.deleteBookCopyById(bookCopy.getId());
        bookService.deleteBookById(book.getId());
        readerService.deleteReaderById(reader.getId());
    }

    @Test
    public void rentBookCopyTest()
    {
        //Given
        Reader reader = new Reader(null, "Name", "Surname", LocalDate.of(2021,6,29));
        readerService.addReader(reader);

        Book book = new Book(null, "Title", "Author", 2021, new ArrayList<>());
        bookService.addBook(book);

        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);
        bookCopyService.addBookCopy(bookCopy);

        Rent rent = new Rent(null, reader, bookCopy, LocalDate.now(), LocalDate.now().plusDays(30));

        //When
        rentService.rentBookCopy(rent);


        //Then
        Assertions.assertEquals("Author", rent.getBookCopy().getBook().getAuthor());
        Assertions.assertEquals(1, rentService.getAllRentedBookCopies().size());

        //Cleanup
        rentService.deleteRentedBookCopyRecord(rent.getId());
        bookCopyService.deleteBookCopyById(bookCopy.getId());
        bookService.deleteBookById(book.getId());
        readerService.deleteReaderById(reader.getId());
    }

    @Test
    public void returnBookCopyTest()
    {
        //Given
        Reader reader = new Reader(null, "Name", "Surname", LocalDate.of(2021,6,29));
        readerService.addReader(reader);

        Book book = new Book(null, "Title", "Author", 2021, new ArrayList<>());
        bookService.addBook(book);

        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);
        bookCopyService.addBookCopy(bookCopy);

        Rent rent = new Rent(null, reader, bookCopy, LocalDate.now(), LocalDate.now().plusDays(30));
        rentService.rentBookCopy(rent);

        //When
        rentService.returnBookCopy(rent.getId());

        //Then
        Assertions.assertEquals(RentalStatus.AVAILABLE, rentService.getAllRentedBookCopies().get(0).getBookCopy().getStatus());

        //Cleanup
        rentService.deleteRentedBookCopyRecord(rent.getId());
        bookCopyService.deleteBookCopyById(bookCopy.getId());
        bookService.deleteBookById(book.getId());
        readerService.deleteReaderById(reader.getId());
    }
}
