package com.erkan.reading.is.good.service;

import com.erkan.reading.is.good.controller.model.request.CustomerRequest;
import com.erkan.reading.is.good.controller.model.response.CustomerResponse;
import com.erkan.reading.is.good.controller.model.response.OrderResponse;
import com.erkan.reading.is.good.entity.Customer;
import com.erkan.reading.is.good.exception.CustomerNotFoundException;
import com.erkan.reading.is.good.repository.CustomerRepository;
import com.erkan.reading.is.good.repository.OrderHeaderRepository;
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

    public List<OrderResponse> getOrdersFromCustomer(Long id) {
        Customer customer = findCustomerById(id);
        List<OrderResponse> orderResponseList = new ArrayList<>();
        orderHeaderRepository.findAllByCustomer(customer, Pageable.ofSize(10)).forEach(order ->
                orderResponseList.add(OrderResponse.of(order)));
        return orderResponseList;
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
}
