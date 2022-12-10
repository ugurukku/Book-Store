package com.folksdev.bookstore;

import com.folksdev.bookstore.models.Book;
import com.folksdev.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }


    @Override
    public void run(String... args){

        Book book = Book.builder().name("Yuzuklerin efendisi").author("JRR Tolkien").price(10.0).stock(15).build();

        Book book2 = Book.builder().name("Harry Potter").author("JK Rowling").price(12.0).stock(18).build();

        Book book3 = Book.builder().name("Murderer in East Express").author("Agatha Cristie").price(13.0).stock(45).build();

        bookRepository.saveAll(Arrays.asList(book, book2, book3));

    }
}
