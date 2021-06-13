package com.crud.library.service;

import com.crud.library.domain.Titles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TitleTestSuite
{
    @Autowired
    private TitlesService service;

    @Test
    public void addTitleTest()
    {
        //Given
        Titles title = new Titles(null, "Title 5", "Author 5", 2021);

        //When
        service.addTitle(title);
        Long titleId = title.getId();

        //Then
        Assertions.assertEquals("Title 5", service.getTitleById(titleId).get().getTitle());
        Assertions.assertNotEquals(0, titleId);
        Assertions.assertEquals(2021, service.getTitleById(titleId).get().getPublishYear());

        //Cleanup
        service.deleteTitleById(titleId);
    }

    @Test
    public void getAllTitlesTest()
    {
        //Given
        Titles title = new Titles(null, "Title 5", "Author 5", 2021);

        //When
        service.addTitle(title);
        List<Titles> titlesList = service.getAllTitles();

        //Then
        Assertions.assertEquals(2, titlesList.size());
        Assertions.assertEquals(title.getTitle(), titlesList.get(1).getTitle());

        //Cleanup
        service.deleteTitleById(title.getId());
    }

    @Test
    public void getTitleByYearTest()
    {
        //Given
        Titles title = new Titles(null, "Title 5", "Author 5", 2021);

        //When
        Titles addedTitle = service.addTitle(title);
        List<Titles> titlesByYear2021 = service.getTitlesByPublishYear(2021);
        Long id = title.getId();

        //Then
        Assertions.assertEquals(addedTitle.getTitle(), titlesByYear2021.get(0).getTitle());

        //Cleanup
        service.deleteTitleById(id);
    }
}
