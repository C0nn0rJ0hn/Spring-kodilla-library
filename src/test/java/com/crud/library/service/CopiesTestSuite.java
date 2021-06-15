package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookCopy;
import com.crud.library.domain.RentalStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CopiesTestSuite
{
    @Autowired
    private BookCopyService service;

    @Autowired
    private BookService bookService;

    @Test
    public void getAllCopiesTest()
    {
        //Given
        Book book = new Book(null, "Title 2", "Author 2", 1999, null);
        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);

        //When
        bookService.addBook(book);
        service.addBookCopy(bookCopy);
        service.getAllBookCopies();

        //Then
        Assertions.assertEquals(1, service.getAllBookCopies().size());

        //Cleanup
        service.deleteBookCopyById(bookCopy.getId());
        bookService.deleteBookById(book.getId());
    }

    @Test
    public void addCopyTest()
    {
        //Given
        Book book = new Book(null, "Title 5", "Author 5", 2008, null);
        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);

        //When
        bookService.addBook(book);
        BookCopy addedCopy = service.addBookCopy(bookCopy);

        //Then
        Assertions.assertNotEquals(0, addedCopy.getId());
        Assertions.assertEquals("Title 5", addedCopy.getBook().getTitle());

        //Cleanup
        service.deleteBookCopyById(addedCopy.getId());
        bookService.deleteBookById(book.getId());
    }

    @Test
    public void updateBookCopyStatusTest()
    {
        //Given
        Book book = new Book(null, "Title 5", "Author 5", 2008, null);
        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);
        bookService.addBook(book);
        service.addBookCopy(bookCopy);

        //When
        service.updateBookCopyStatus(bookCopy.getId(), RentalStatus.RENTED);
        RentalStatus result = service.getBookCopyById(bookCopy.getId()).get().getStatus();

        //Then
        Assertions.assertEquals(RentalStatus.RENTED, result);

        //Cleanup
        service.deleteBookCopyById(bookCopy.getId());
        bookService.deleteBookById(book.getId());
    }

    @Test
    public void availableBookCopiesTest()
    {
        //Given
        Book book = new Book(null, "Title 5", "Author 5", 2008, null);
        BookCopy bookCopy = new BookCopy(null, RentalStatus.AVAILABLE, book);
        BookCopy bookCopy1 = new BookCopy(null, RentalStatus.LOST, book);
        BookCopy bookCopy2 = new BookCopy(null, RentalStatus.AVAILABLE, book);
        BookCopy bookCopy3 = new BookCopy(null, RentalStatus.RENTED, book);
        bookService.addBook(book);
        service.addBookCopy(bookCopy);
        service.addBookCopy(bookCopy1);
        service.addBookCopy(bookCopy2);
        service.addBookCopy(bookCopy3);

        //When
        int result = service.bookCopiesAvailableToRent("Title 5");

        //Then
        Assertions.assertEquals(2, result);

        //Cleanup
        service.deleteBookCopyById(bookCopy.getId());
        service.deleteBookCopyById(bookCopy1.getId());
        service.deleteBookCopyById(bookCopy2.getId());
        service.deleteBookCopyById(bookCopy3.getId());
        bookService.deleteBookById(book.getId());
    }
}
