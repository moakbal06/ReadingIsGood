package com.onur.reading.service;

import com.onur.reading.controller.model.request.CustomerRequest;
import com.onur.reading.controller.model.response.CustomerResponse;
import com.onur.reading.controller.model.response.OrderResponse;
import com.onur.reading.entity.Customer;
import com.onur.reading.exception.CustomerNotFoundException;
import com.onur.reading.repository.CustomerRepository;
import com.onur.reading.repository.OrderHeaderRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderHeaderRepository orderHeaderRepository;

    public CustomerService(CustomerRepository customerRepository,
                           OrderHeaderRepository orderHeaderRepository) {
        this.customerRepository = customerRepository;
        this.orderHeaderRepository = orderHeaderRepository;
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRepository.save(Customer.of(customerRequest));
        return CustomerResponse.of(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
}
