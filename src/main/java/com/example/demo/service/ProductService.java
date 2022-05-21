package com.example.demo.service;

import com.example.demo.model.Product;

public interface ProductService {
    Object getById(String code);

    Object findAll();

    boolean checkCodeExist(String code);

    void save(Product product);

    void deleteById(String code);
}
