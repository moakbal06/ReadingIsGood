package com.onur.reading.controller.model.response;

import com.onur.reading.entity.OrderHeader;
import com.onur.reading.enums.OrderHeaderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long id;
    private CustomerResponse customer;
    private List<OrderLinesResponse> lines;
    private Long totalQuantity;
    private OrderHeaderStatus orderStatus;

    public static OrderResponse of(OrderHeader orderHeader) {
        OrderResponse orderResponse = OrderResponse.builder()
                .id(orderHeader.getId())
                .customer(CustomerResponse.of(orderHeader.getCustomer()))
                .totalQuantity(orderHeader.getTotalQuantity())
                .orderStatus(orderHeader.getOrderStatus())
                .build();
        List<OrderLinesResponse> orderLinesResponseList = new ArrayList<>();
        orderHeader.getLines().forEach(e -> {
            orderLinesResponseList.add(OrderLinesResponse.builder()
                    .quantity(e.getQuantity())
                    .id(e.getId())
                    .orderStatus(e.getOrderStatus())
                    .book(BookResponse.builder()
                            .id(e.getBook().getId())
                            .name(e.getBook().getName())
                            .ISBN(e.getBook().getISBN())
                            .quantity(e.getQuantity())
                            .build())
                    .build());
        });
        orderResponse.setLines(orderLinesResponseList);
        return orderResponse;
    }
}
