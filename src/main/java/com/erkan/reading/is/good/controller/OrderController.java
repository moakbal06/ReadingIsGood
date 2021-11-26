package com.erkan.reading.is.good.controller;

import com.erkan.reading.is.good.controller.model.request.OrderRequest;
import com.erkan.reading.is.good.controller.model.response.OrderResponse;
import com.erkan.reading.is.good.entity.OrderHeader;
import com.erkan.reading.is.good.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
}
