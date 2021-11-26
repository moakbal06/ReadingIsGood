package com.erkan.reading.is.good.service;

import com.erkan.reading.is.good.controller.model.request.BookRequest;
import com.erkan.reading.is.good.controller.model.request.OrderRequest;
import com.erkan.reading.is.good.controller.model.response.OrderResponse;
import com.erkan.reading.is.good.entity.*;
import com.erkan.reading.is.good.exception.BookNotFoundException;
import com.erkan.reading.is.good.exception.OrderNotFoundException;
import com.erkan.reading.is.good.exception.OutOfStockException;
import com.erkan.reading.is.good.repository.BookRepository;
import com.erkan.reading.is.good.repository.BookStockRepository;
import com.erkan.reading.is.good.repository.OrderHeaderRepository;
import lombok.extern.slf4j.Slf4j;
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
    private final BookRepository bookRepository;
    private final BookStockRepository bookStockRepository;

    public OrderService(OrderHeaderRepository orderHeaderRepository,
                        CustomerService customerService,
                        BookRepository bookRepository,
                        BookStockRepository bookStockRepository) {
        this.orderHeaderRepository = orderHeaderRepository;
        this.customerService = customerService;
        this.bookRepository = bookRepository;
        this.bookStockRepository = bookStockRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class, isolation = Isolation.READ_COMMITTED)
    public OrderResponse createOrder(OrderRequest orderRequest) {
        log.info("Order Creation Log started!");
        Customer customer = customerService.findCustomerById(orderRequest.getCustomerId());

        List<OrderLine> orderLineList = new ArrayList<>();
        BigDecimal totalAmount = new BigDecimal(0);
        OrderHeader orderHeader = OrderHeader.builder()
                .customer(customer)
                .lines(orderLineList)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        for (BookRequest bt : orderRequest.getBookRequestList()) {
            Book book = bookRepository.findById(bt.getBookId()).orElseThrow(BookNotFoundException::new);
            getAndDeductBookStock(book);
            OrderLine ol = OrderLine.builder()
                    .book(book)
                    .header(orderHeader)
                    .amount(book.getAmount())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            totalAmount = totalAmount.add(book.getAmount());
            orderLineList.add(ol);
        }
        orderHeader.setTotalAmount(totalAmount);
        OrderHeader oh = orderHeaderRepository.save(orderHeader);
        return OrderResponse.of(oh);
    }

    public void getAndDeductBookStock(Book book) {
        BookStock bookStock = bookStockRepository.findByBook(book);
        if (bookStock.getQuantity() < 1) {
            throw new OutOfStockException(book.getName() + " is out of stock!");
        }
        bookStock.setQuantity(bookStock.getQuantity() - 1);
        bookStockRepository.save(bookStock);
    }

    public OrderResponse getOrderById(Long id) {
        OrderHeader oh = orderHeaderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return OrderResponse.of(oh);
    }
}
