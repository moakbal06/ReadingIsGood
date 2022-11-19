package com.onur.reading.service;

import com.onur.reading.controller.model.request.CustomerRequest;
import com.onur.reading.controller.model.response.CustomerResponse;
import com.onur.reading.controller.model.response.OrderResponse;
import com.onur.reading.entity.Book;
import com.onur.reading.entity.Customer;
import com.onur.reading.entity.OrderHeader;
import com.onur.reading.entity.OrderLine;
import com.onur.reading.exception.CustomerNotFoundException;
import com.onur.reading.repository.CustomerRepository;
import com.onur.reading.repository.OrderHeaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    @Spy
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;


    private static CustomerRequest customerRequest;

    @BeforeEach
    public void init() {
        customerRequest = CustomerRequest.builder()
                .name("onur")
                .build();
    }

    @Test()
    public void createCustomerTest_whenCustomerRequestComesIn_thenReturnSuccessCustomerResponse() {
        // GIVEN
        Customer customer =  Customer.builder()
                .name("onur")
                .id(1L)
                .build();
        when(customerRepository.save(any(Customer.class)))
                .thenReturn(customer);
        // WHEN
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
        // THEN
        assertThat(customerResponse.getId()).isEqualTo(1L);
        assertThat(customerResponse.getName()).isEqualTo("onur");
    }




}
