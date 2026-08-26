package com.error418.backend.service;

import com.error418.backend.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> productsList();
    Product productList(int id);
    Product registerProduct(Product producto);
}

