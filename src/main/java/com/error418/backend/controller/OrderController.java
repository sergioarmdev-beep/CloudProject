package com.error418.backend.controller;

import com.error418.backend.model.Order;
import com.error418.backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Order>> listOrders() {
        return ResponseEntity.ok(orderService.listOrders());
    }

    @PostMapping("/registrarOrden")
    public ResponseEntity<Order> registerOrders(@RequestBody Order order) {
        return new ResponseEntity<>(
                orderService.registerOrder(order),
                HttpStatus.CREATED
        );
    }
}