package com.crud.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CopiesTestSuite
{
    @Autowired
    private BookCopyService service;

    @Autowired
    private BookService bookService;

}
