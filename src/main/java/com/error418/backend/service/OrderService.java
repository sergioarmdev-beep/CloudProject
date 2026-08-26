package com.error418.backend.service;

import com.error418.backend.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> listOrders();
    Order registerOrder(Order order);
}

