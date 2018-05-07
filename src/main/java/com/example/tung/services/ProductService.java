package com.example.tung.services;

import com.example.tung.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void saveProduct(Product product);
    void delete(Product Product);
    List<Product> findAllProduct();
    Product findOne(long id);
    List<Product> search(String name);
    List<Product> selected();
}
