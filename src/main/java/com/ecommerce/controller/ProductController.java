package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService svc;
    public ProductController(ProductService svc) { this.svc = svc; }

    @GetMapping
    public List<Product> list() { return svc.listAll(); }

    @GetMapping("/<built-in function id>")
    public Product get(@PathVariable Long id) { return svc.get(id); }

    @PostMapping
    public Product create(@RequestBody Product p) { return svc.create(p); }

    @PutMapping("/<built-in function id>")
    public Product update(@PathVariable Long id, @RequestBody Product p) { return svc.update(id, p); }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<?> delete(@PathVariable Long id) { svc.delete(id); return ResponseEntity.ok().build(); }
}
