package com.crud.library.service;

import com.crud.library.domain.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderTestSuite
{
    @Autowired
    private ReaderService service;

    @Test
    public void testAddNewReader()
    {
        //Given
        Reader reader = new Reader(null, "John", "Webber", LocalDate.of(2021, 06, 10));

        //When
        service.addReader(reader);
        Long readerId = reader.getId();

        //Then
        Assertions.assertNotEquals(0, readerId);
        Assertions.assertEquals("John", service.getReaderById(readerId).get().getName());

        //Cleanup
        service.deleteReaderById(readerId);
    }

    @Test
    public void testGetAllReaders()
    {
        //Given
        Reader reader1 = new Reader(null, "Reader1", "Reader1", LocalDate.of(2020, 10,12));

        //When
        service.addReader(reader1);
        List<Reader> readerList = service.getAllReaders();
        Long id = reader1.getId();

        //Then
        Assertions.assertEquals(1, readerList.size());
        Assertions.assertEquals("Reader1", service.getReaderById(id).get().getSurname());

        //Cleanup
        service.deleteReaderById(id);
    }

    @Test
    public void testGetReaderById()
    {
        //Given
        Reader reader1 = new Reader(null, "Reader1", "Reader1", LocalDate.of(2020, 10,12));

        //When
        service.addReader(reader1);
        Long readerId = reader1.getId();

        //Then
        Assertions.assertNotEquals(0, readerId);

        //Cleanup
        service.deleteReaderById(readerId);
    }
}
