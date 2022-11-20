package com.onur.reading.service;

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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {


    @Mock
    private CustomerService customerService;

    @Mock
    private OrderHeaderRepository orderHeaderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createOrder() {
    }

    @Test
    void getAndDeductBookStock() {
    }

    @Test
    void getOrderById() {
    }

    @Test
    void getOrdersFromCustomer() {
    }
    @Test()
    public void getOrdersFromCustomerTest_whenCustomerNotFound_thenThrowCustomerNotFoundException() {
        // GIVEN
        when(customerService.findCustomerById(1L))
                .thenThrow(new CustomerNotFoundException());
        // WHEN THEN
        assertThrows(CustomerNotFoundException.class, () -> orderService.getOrdersFromCustomer(1L));
    }
    @Test()
    public void getOrdersFromCustomerTest_whenOrdersFetched_thenReturnOrderResponseList() {
        // GIVEN
        Customer c1 = Customer.builder()
                .id(1L)
                .name("Customer1").build();
        OrderLine orderLine = OrderLine.builder()
                .quantity(12L)
                .book(Book.builder()
                        .id(1L)
                        .name("Book1").build())
                .id(1L).build();
        OrderHeader oh = OrderHeader.builder()
                .customer(c1)
                .id(1L)
                .totalQuantity(100L)
                .lines(Collections.singletonList(orderLine)).build();
        Page<OrderHeader> page = new PageImpl<>(Collections.singletonList(oh));
        when(customerService.findCustomerById(1L)).thenReturn(c1);
        when(orderHeaderRepository.findAllByCustomer(eq(c1), any(Pageable.class))).thenReturn(page);

        // WHEN
        List<OrderResponse> list = orderService.getOrdersFromCustomer(1L);
        // THEN
        assertThat(list.get(0).getLines().get(0).getQuantity()).isEqualTo(12L);
        assertThat(list.get(0).getLines().get(0).getId()).isEqualTo(1);

    }
}