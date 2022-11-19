package com.onur.reading.controller;

import com.onur.reading.controller.model.request.OrderRequest;
import com.onur.reading.controller.model.response.OrderResponse;
import com.onur.reading.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.createOrder(orderRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/interval")
    public String getOrderByDates(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return "pong";
    }

    @GetMapping("getOrdersByCustomerId/{id}")
    public ResponseEntity<List<OrderResponse>> getAllOrdersOfCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrdersFromCustomer(id));
    }
}
