package com.error418.backend.service;

import com.error418.backend.model.Product;
import com.error418.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> productsList() {
        return  productRepository.findAll();
    }

    @Override
    public Product productList(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Product registerProduct(Product producto) {
        return productRepository.save(producto);
    }
}

