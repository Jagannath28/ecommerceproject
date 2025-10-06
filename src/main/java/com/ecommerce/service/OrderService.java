package com.ecommerce.service;

import com.ecommerce.model.*;
import com.ecommerce.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, CartRepository cartRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo; this.cartRepo = cartRepo; this.productRepo = productRepo;
    }

    public Order checkout(Long userId) {
        Cart cart = cartRepo.findByUserId(userId).orElseThrow();
        Order order = Order.builder()
                .user(cart.getUser())
                .createdAt(LocalDateTime.now())
                .status("CREATED")
                .build();

        double total = 0;
        for (CartItem ci : cart.getItems()) {
            Product p = productRepo.findById(ci.getProduct().getId()).orElseThrow();
            OrderItem oi = OrderItem.builder().product(p).quantity(ci.getQuantity()).price(p.getPrice()).build();
            order.getItems().add(oi);
            total += p.getPrice() * ci.getQuantity();
            p.setStock(p.getStock() - ci.getQuantity());
            productRepo.save(p);
        }
        order.setTotalAmount(total);
        Order saved = orderRepo.save(order);
        cart.getItems().clear();
        cartRepo.save(cart);
        return saved;
    }
}
