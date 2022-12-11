package com.folksdev.bookstore.service;


import com.folksdev.bookstore.models.Book;
import com.folksdev.bookstore.repository.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class BookServiceTest {

    private BookService bookService;

    private BookRepository bookRepository;


    @Before
    public void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void whenCallFindAllBooksWithValidRequest_itShouldReturnValidBooks() {
        Book book = Book.builder().id(1).name("Yuzuklerin efendisi").author("JRR Tolkien").price(10.4).stock(15).build();
        Book book2 = Book.builder().id(2).name("Harry Potter").author("JK Rowling").price(12.0).stock(18).build();
        Book book3 = Book.builder().id(3).name("Murderer in East Express").author("Agatha Cristie").price(13.0).stock(45).build();

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);

        System.out.println(bookList);

        Mockito.when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> result = bookService.findAll();
        System.out.println(result);
        Assert.assertEquals(bookList, result);

        Mockito.verify(bookRepository).findAll();
    }

    @Test
    public void whenCallFindBookByIdWithValidRequest_itShouldReturnValidBook() {

        Optional<Book> book = Optional.of(Book.builder()
                .id(1)
                .name("Yuzuklerin efendisi")
                .author("JRR Tolkien")
                .price(10.4)
                .stock(15)
                .build());

        Mockito.when(bookRepository.findById(1)).thenReturn(book);

        Optional<Book> result = bookService.findById(1);

        Assert.assertEquals(book, result);

        Mockito.verify(bookRepository).findById(1);

    }
}