package com.crud.library.service;

import com.crud.library.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTestSuite
{
    @Autowired
    private BookService service;

    @Test
    public void addBookTest()
    {
        //Given
        Book book = new Book(null, "Title 1", "Author 1", 2000, null);

        //When
        service.addBook(book);
        Long id = book.getId();

        //Then
        Assertions.assertEquals("Title 1", service.getBookById(id).get().getTitle());
        Assertions.assertNotEquals(0, id);

        //Cleanup
        service.deleteBookById(id);
    }

    @Test
    public void getBookByYearTest()
    {
        //Given
        Book book = new Book(null, "Title 1", "Author 1", 2000, null);
        Book book2 = new Book(null, "Title 2", "Author 2", 1950, null);
        Book book3 = new Book(null, "Title 3", "Author 3", 2000, null);
        service.addBook(book);
        service.addBook(book2);
        service.addBook(book3);

        //When
        List<Book> listBookByYear2000 = service.getBookByPublishYear(2000);

        //Then
        Assertions.assertEquals(2, listBookByYear2000.size());

        //Cleanup
        service.deleteBookById(book.getId());
        service.deleteBookById(book2.getId());
        service.deleteBookById(book3.getId());
    }

    @Test
    public void getAllBooks()
    {
        //Given
        Book book = new Book(null, "Title 1", "Author 1", 2000, null);
        Book book2 = new Book(null, "Title 2", "Author 2", 1950, null);
        Book book3 = new Book(null, "Title 3", "Author 3", 2000, null);
        service.addBook(book);
        service.addBook(book2);
        service.addBook(book3);

        //When
        List<Book> booksList = service.getAllBooks();

        //Then
        Assertions.assertEquals(3, booksList.size());
        Assertions.assertEquals("Title 1", booksList.get(0).getTitle());

        //Cleanup
        service.deleteBookById(book.getId());
        service.deleteBookById(book2.getId());
        service.deleteBookById(book3.getId());
    }
}
