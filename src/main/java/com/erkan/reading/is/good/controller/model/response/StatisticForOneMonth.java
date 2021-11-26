package com.erkan.reading.is.good.controller.model.response;

import com.erkan.reading.is.good.repository.StatisticForOneMonthConverter;
import com.erkan.reading.is.good.util.RIGUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticForOneMonth {

    private String month;
    private String year;
    private Long totalOrderCount;
    private Long totalBookCount;
    private BigDecimal totalPurchasedAmount;

    public static StatisticForOneMonth of(StatisticForOneMonthConverter e) {
        return StatisticForOneMonth.builder()
                .month(RIGUtils.getMonth(e.getMonth()))
                .year(RIGUtils.getYear(e.getMonth()))
                .totalBookCount(e.getTotalBookCount())
                .totalOrderCount(e.getTotalOrderCount())
                .totalPurchasedAmount(e.getTotalPurchasedAmount())
                .build();
    }
}
