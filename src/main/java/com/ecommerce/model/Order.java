package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Double totalAmount;

    private String status; // CREATED, PAID, SHIPPED

    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();
}

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;

    private Double price;
}
