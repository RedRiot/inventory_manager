package com.example.tung.services;

import com.example.tung.models.Product;
import com.example.tung.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);

    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> allProducts= new ArrayList<>();
        productRepository.findAll().forEach(allProducts::add);
        return allProducts;
    }

    @Override
    public Product findOne(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> search(String name) {
        List<Product> list = productRepository.findAllByNameContains(name);
        return list;
    }

    @Override
    public List<Product> selected() {
        return productRepository.findAllByItemBuyingGreaterThan(0);
    }
}
