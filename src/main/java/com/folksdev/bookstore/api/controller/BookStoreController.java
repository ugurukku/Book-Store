package com.folksdev.bookstore.api.controller;

import com.folksdev.bookstore.dto.BookOrderRequest;
import com.folksdev.bookstore.models.Book;
import com.folksdev.bookstore.models.Order;
import com.folksdev.bookstore.service.BookService;
import com.folksdev.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> sayHello() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUsername());
        return ResponseEntity.ok(order);
    }

}
