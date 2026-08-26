package com.error418.backend.controller;

import com.error418.backend.model.Product;
import com.error418.backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listarProductos")
    public ResponseEntity<List<Product>> listProducts(){
        return new ResponseEntity<List<Product>>(productService.productsList(), HttpStatus.OK);
    }

    @GetMapping("/listarProducto/{id}")
    public ResponseEntity<Product>listProduct(@PathVariable("id") int id){
        return new ResponseEntity<Product>(productService.productList(id), HttpStatus.OK);
    }

    @PostMapping("/registrarProducto")
    public ResponseEntity<Product> registerProduct(@RequestBody Product  product){
        return new ResponseEntity<Product>(productService.registerProduct(product), HttpStatus.CREATED);
    }
}
