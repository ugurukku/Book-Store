package com.folksdev.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "bookOrder")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    @ElementCollection(targetClass = Integer.class)
    private List<Integer> bookList;

    private Double totalPrice;

}
