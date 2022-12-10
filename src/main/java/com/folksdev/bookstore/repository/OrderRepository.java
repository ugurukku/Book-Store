package com.folksdev.bookstore.repository;

import com.folksdev.bookstore.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
