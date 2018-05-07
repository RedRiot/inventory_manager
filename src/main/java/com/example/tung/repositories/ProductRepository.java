package com.example.tung.repositories;

import com.example.tung.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByNameContains(String name);
    List<Product> findAllByItemBuyingGreaterThan(int number);
}
