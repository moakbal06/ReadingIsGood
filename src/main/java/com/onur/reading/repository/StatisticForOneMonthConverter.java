package com.onur.reading.repository;

import java.math.BigDecimal;

public interface StatisticForOneMonthConverter {
    String getMonthx();

    Long getTotalOrderCount();

    Long getTotalBookCount();

}
