package com.erkan.reading.is.good.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {
    private String name;
    private Long authorId;

    private Long quantity;
    private BigDecimal amount;
}
