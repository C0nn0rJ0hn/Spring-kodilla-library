package com.crud.library.service;

import com.crud.library.domain.Readers;
import com.crud.library.service.ReadersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class ReaderTestSuite
{
    @Autowired
    private ReadersService service;

    @Test
    public void testAddNewReader()
    {
        //Given
        Readers reader = new Readers(null, "John", "Webber", LocalDate.of(2021, 06, 10));

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
        Readers reader1 = new Readers(null, "Reader1", "Reader1", LocalDate.of(2020, 10,12));

        //When
        service.addReader(reader1);
        List<Readers> readersList = service.getAllReaders();
        Long id = reader1.getId();

        //Then
        Assertions.assertEquals(2, readersList.size());
        Assertions.assertEquals("Reader1", service.getReaderById(id).get().getSurname());

        //Cleanup
        service.deleteReaderById(id);
    }

    @Test
    public void testGetReaderById()
    {
        //Given
        Readers reader1 = new Readers(null, "Reader1", "Reader1", LocalDate.of(2020, 10,12));

        //When
        service.addReader(reader1);
        Long readerId = reader1.getId();

        //Then
        Assertions.assertNotEquals(0, readerId);

        //Cleanup
        service.deleteReaderById(readerId);
    }
}
