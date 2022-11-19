package com.onur.reading.service;

import com.onur.reading.entity.OrderHeader;
import com.onur.reading.enums.OrderHeaderStatus;
import com.onur.reading.enums.OrderLineStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@EnableScheduling
@EnableAsync
public class StockCheckerService {

    private final OrderService orderService;

    public StockCheckerService(OrderService orderService) {
        this.orderService = orderService;
    }


    @Scheduled(fixedRate = 5_999, initialDelayString = "1200")
    @Transactional
    public void checkOrdersForStock()  {

        List<OrderHeader> ordersByStatus = orderService.getOrdersByStatus(OrderHeaderStatus.NOT_COMPLETED);

        ordersByStatus.forEach(orderHeader -> {
            orderHeader.getLines().stream()
                    .filter(orderLine -> OrderLineStatus.PENDING.equals(orderLine.getOrderStatus()))
                    .forEach(orderLine -> {
                        OrderLineStatus newStatus = orderService.getAndDeductBookStock(orderLine);
                        orderLine.setOrderStatus(newStatus);
                    });
            orderService.saveOrderHeader(orderHeader);
        });


    }
    @Scheduled(fixedRate = 3_999, initialDelayString = "12000")
    @Transactional
    public void validateOrderHeaderStatueses()  {

        List<OrderHeader> ordersByStatus = orderService.getOrdersByStatus(OrderHeaderStatus.NOT_COMPLETED);

        ordersByStatus.forEach(orderHeader -> {
            boolean isCompleted = orderHeader.getLines().stream().allMatch(orderLine -> !OrderLineStatus.PENDING.equals(orderLine.getOrderStatus()));
            if(isCompleted){
                orderHeader.setOrderStatus(OrderHeaderStatus.COMPLETED);
                orderService.saveOrderHeader(orderHeader);
            }
        });
    }
}
