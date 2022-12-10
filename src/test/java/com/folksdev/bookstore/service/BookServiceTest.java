package com.folksdev.bookstore.service;


import com.folksdev.bookstore.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BookServiceTest {

    private BookService bookService;

    private BookRepository bookRepository;

    @Before
    public void setUp() {

        bookRepository = Mockito.mock(BookRepository.class);

        bookService = new BookService(bookRepository);
    }

    @Test
    public void whenCallBookByIdWithValidRequest_itShouldReturnValidBook(){

    }
}