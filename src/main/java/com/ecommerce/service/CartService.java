package com.ecommerce.service;

import com.ecommerce.model.*;
import com.ecommerce.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public CartService(CartRepository cartRepo, ProductRepository productRepo, UserRepository userRepo) {
        this.cartRepo = cartRepo; this.productRepo = productRepo; this.userRepo = userRepo;
    }

    public Cart getOrCreateCart(Long userId) {
        return cartRepo.findByUserId(userId).orElseGet(() -> {
            User u = userRepo.findById(userId).orElseThrow();
            Cart c = Cart.builder().user(u).build();
            return cartRepo.save(c);
        });
    }

    public Cart addToCart(Long userId, Long productId, int qty) {
        Cart cart = getOrCreateCart(userId);
        Product p = productRepo.findById(productId).orElseThrow();
        CartItem item = CartItem.builder().product(p).quantity(qty).build();
        cart.getItems().add(item);
        return cartRepo.save(cart);
    }
}
