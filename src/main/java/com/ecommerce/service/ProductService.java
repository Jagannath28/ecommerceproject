package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(Product p) { return repo.save(p); }
    public List<Product> listAll() { return repo.findAll(); }
    public Product get(Long id) { return repo.findById(id).orElseThrow(); }
    public Product update(Long id, Product p) {
        Product ex = repo.findById(id).orElseThrow();
        ex.setName(p.getName());
        ex.setDescription(p.getDescription());
        ex.setPrice(p.getPrice());
        ex.setStock(p.getStock());
        ex.setCategory(p.getCategory());
        return repo.save(ex);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
