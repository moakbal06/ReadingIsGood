package com.erkan.reading.is.good.controller.model.response;

import com.erkan.reading.is.good.entity.Customer;
import com.erkan.reading.is.good.entity.OrderHeader;
import com.erkan.reading.is.good.entity.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.fileslice.ArraySlice;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private BigDecimal totalAmount;

    public static OrderResponse of(OrderHeader orderHeader) {
        OrderResponse orderResponse = OrderResponse.builder()
                .id(orderHeader.getId())
                .customer(CustomerResponse.of(orderHeader.getCustomer()))
                .totalAmount(orderHeader.getTotalAmount())
                .build();
        List<OrderLinesResponse> orderLinesResponseList = new ArrayList<>();
        orderHeader.getLines().forEach(e -> {
            orderLinesResponseList.add(OrderLinesResponse.builder()
                    .amount(e.getAmount())
                    .id(e.getId())
                    .book(BookResponse.builder()
                            .id(e.getBook().getId())
                            .name(e.getBook().getName())
                            .build())
                    .build());
        });
        orderResponse.setLines(orderLinesResponseList);
        return orderResponse;
    }
}
