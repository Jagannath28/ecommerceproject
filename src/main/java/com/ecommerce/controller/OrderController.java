package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService svc;
    public OrderController(OrderService svc) { this.svc = svc; }

    @PostMapping("/checkout")
    public Order checkout(@RequestParam Long userId) { return svc.checkout(userId); }
}
