package com.erkan.reading.is.good.controller;

import com.erkan.reading.is.good.controller.model.request.CustomerRequest;
import com.erkan.reading.is.good.controller.model.response.CustomerResponse;
import com.erkan.reading.is.good.controller.model.response.OrderResponse;
import com.erkan.reading.is.good.entity.OrderHeader;
import com.erkan.reading.is.good.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequest));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrdersOfCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getOrdersFromCustomer(id));
    }
}
