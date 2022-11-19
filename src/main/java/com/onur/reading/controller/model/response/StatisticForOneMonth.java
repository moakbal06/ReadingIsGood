package com.onur.reading.controller.model.response;

import com.onur.reading.repository.StatisticForOneMonthConverter;
import com.onur.reading.util.RIGUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.ParseException;

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
        try {
            return StatisticForOneMonth.builder()
                    .month(RIGUtils.getMonth(e.getMonthx()))
                    .year(RIGUtils.getYear(e.getMonthx()))
                    .totalBookCount(e.getTotalBookCount())
                    .totalOrderCount(e.getTotalOrderCount())
                    .build();
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }
}
