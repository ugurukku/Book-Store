package com.folksdev.bookstore.service;

import com.folksdev.bookstore.models.Book;
import com.folksdev.bookstore.models.Order;
import com.folksdev.bookstore.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OrderServiceTest {

    private OrderService orderService;

    private OrderRepository orderRepository;
    private BookService bookService;

    @Before
    public void setUp() {
        orderRepository = Mockito.mock(OrderRepository.class);
        bookService = Mockito.mock(BookService.class);

        orderService = new OrderService(orderRepository, bookService);
    }

    @Test
    public void whenCallPutAnOrderWithValidRequest_itShouldReturnValidOrder() {

        List<Integer> idList = Arrays.asList(1, 2, 2);
        String username = "kenananas";

        Book book = Book.builder()
                .id(1)
                .name("Kirmizi papakli kadin")
                .price(23.0)
                .author("Ugur Karimov")
                .stock(13)
                .build();

        Order order = Order.builder()
                .bookList(idList)
                .totalPrice(69.0)
                .userName(username)
                .build();

        for (Integer i : idList) {
            Mockito.when(bookService.findById(i)).thenReturn(Optional.of(book));
        }

        Mockito.when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.putAnOrder(idList,username);

        Assert.assertEquals(order,result);

        for (Integer i : idList) {
            Mockito.verify(bookService).findById(i);
        }

        Mockito.verify(orderRepository).save(order);
    }

}