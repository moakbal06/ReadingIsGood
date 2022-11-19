package com.onur.reading.service;

import com.onur.reading.controller.model.request.BookRequest;
import com.onur.reading.controller.model.request.OrderRequest;
import com.onur.reading.controller.model.response.OrderResponse;
import com.onur.reading.entity.*;
import com.onur.reading.enums.OrderHeaderStatus;
import com.onur.reading.enums.OrderLineStatus;
import com.onur.reading.exception.OrderNotFoundException;
import com.onur.reading.repository.BookStockRepository;
import com.onur.reading.repository.OrderHeaderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    private final OrderHeaderRepository orderHeaderRepository;
    private final CustomerService customerService;
    private final BookService bookService;
    private final BookStockRepository bookStockRepository;

    public OrderService(OrderHeaderRepository orderHeaderRepository,
                        CustomerService customerService,
                        BookService bookService,
                        BookStockRepository bookStockRepository) {
        this.orderHeaderRepository = orderHeaderRepository;
        this.customerService = customerService;
        this.bookService = bookService;
        this.bookStockRepository = bookStockRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class, isolation = Isolation.READ_COMMITTED)
    public OrderResponse createOrder(OrderRequest orderRequest) {
        log.info("Order Creation Log started for" + orderRequest.getCustomerId());
        Customer customer = customerService.findCustomerById(orderRequest.getCustomerId());

        List<OrderLine> orderLineList = new ArrayList<>();
        Long totalQuantity = 0L;
        OrderHeader orderHeader = OrderHeader.builder()
                .customer(customer)
                .lines(orderLineList)
                .orderStatus(OrderHeaderStatus.NOT_COMPLETED)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        for (BookRequest bt : orderRequest.getBookRequestList()) {
            Book book = bookService.getBookById(bt.getBookId());
            OrderLine ol = OrderLine.builder()
                    .book(book)
                    .header(orderHeader)
                    .quantity(bt.getQuantity())
                    .orderStatus(OrderLineStatus.PENDING)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            totalQuantity = totalQuantity + bt.getQuantity();
            orderLineList.add(ol);
        }
        orderHeader.setTotalQuantity(totalQuantity);
        OrderHeader oh = orderHeaderRepository.save(orderHeader);
        return OrderResponse.of(oh);
    }

    @Transactional
    public OrderLineStatus getAndDeductBookStock(OrderLine orderLine) {
        BookStock bookStock = bookStockRepository.findByBook(orderLine.getBook());
        if (bookStock.getQuantity() < orderLine.getQuantity()) {
            return OrderLineStatus.REJECTED;
        }
        bookStock.setQuantity(bookStock.getQuantity() - orderLine.getQuantity());
        bookStockRepository.save(bookStock);
        return OrderLineStatus.ACCEPTED;
    }

    public OrderResponse getOrderById(Long id) {
        OrderHeader oh = orderHeaderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return OrderResponse.of(oh);
    }
    public List<OrderResponse> getOrdersFromCustomer(Long id) {
        Customer customer = customerService.findCustomerById(id);
        List<OrderResponse> orderResponseList = new ArrayList<>();
        orderHeaderRepository.findAllByCustomer(customer, Pageable.ofSize(10)).forEach(order ->
                orderResponseList.add(OrderResponse.of(order)));
        return orderResponseList;
    }

    public List<OrderHeader> getOrdersByStatus(OrderHeaderStatus orderHeaderStatus) {

        List<OrderHeader> orderHeaders = orderHeaderRepository.findAllOrderHeaderByOrderStatusOrderByCreatedAtAsc(orderHeaderStatus);
        return orderHeaders;

    }

    @Transactional
    public void saveOrderHeader(OrderHeader orderHeader) {
        orderHeaderRepository.save(orderHeader);
    }
}
