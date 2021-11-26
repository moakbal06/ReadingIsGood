package com.erkan.reading.is.good.controller.model.response;

import com.erkan.reading.is.good.entity.Book;
import com.erkan.reading.is.good.entity.OrderHeader;
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
    private BigDecimal amount;
}
