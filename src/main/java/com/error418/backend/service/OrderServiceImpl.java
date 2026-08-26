package com.error418.backend.service;

import com.error418.backend.model.Order;
import com.error418.backend.model.Product;
import com.error418.backend.repository.OrderRepository;
import com.error418.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order registerOrder(Order order) {
        Product product = productRepository.findById(order.getProductId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        order.setTotal(product.getPrice() * order.getCuantity());

        return orderRepository.save(order);
    }
}
