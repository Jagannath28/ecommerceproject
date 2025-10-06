package com.ecommerce.controller;

import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService svc;
    public CartController(CartService svc) { this.svc = svc; }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int qty) {
        return svc.addToCart(userId, productId, qty);
    }
}
