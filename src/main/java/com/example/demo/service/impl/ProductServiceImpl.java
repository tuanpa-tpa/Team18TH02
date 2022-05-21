package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Object getById(String code) {
        return productRepository.getById(code);
    }

    @Override
    public Object findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean checkCodeExist(String code) {
        return productRepository.existsByCode(code);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(String code) {
        productRepository.deleteById(code);
    }
}
