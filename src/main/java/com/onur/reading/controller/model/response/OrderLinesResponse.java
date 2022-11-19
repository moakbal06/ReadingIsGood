package com.onur.reading.controller.model.response;

import com.onur.reading.enums.OrderLineStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLinesResponse {
    private Long id;
    private BookResponse book;
    private Long quantity;
    private OrderLineStatus orderStatus;
}
