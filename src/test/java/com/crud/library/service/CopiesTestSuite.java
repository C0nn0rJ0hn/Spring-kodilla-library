package com.crud.library.service;

import com.crud.library.domain.Books;
import com.crud.library.domain.RentalStatus;
import com.crud.library.domain.Titles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CopiesTestSuite
{
    @Autowired
    private BooksService service;

    @Autowired
    private TitlesService titlesService;

    @Test
    public void addNewCopyTest()
    {
        //Given
        Titles title = new Titles(null, "Title 5", "Author 5", 2000);
        Books copy = new Books(null, RentalStatus.AVAILABLE, title);

        //When
        titlesService.addTitle(title);
        service.addBookCopy(copy);
        Long copyId = copy.getId();
        Long titleId = title.getId();

        //Then
        Assertions.assertEquals(RentalStatus.AVAILABLE, service.getBookCopyById(copyId).get().getStatus());
        //Assertions.assertEquals("Author 5", service.getBookCopyById(copyId).get().getTitle().getAuthor());

        //Cleanup
        titlesService.deleteTitleById(titleId);
        service.deleteBookCopyById(copyId);
    }
}
