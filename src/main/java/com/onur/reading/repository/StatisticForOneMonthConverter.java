package com.onur.reading.repository;

import java.math.BigDecimal;

public interface StatisticForOneMonthConverter {
    String getDate();

    Long getTotalOrderCount();

    Long getTotalBookCount();

}
