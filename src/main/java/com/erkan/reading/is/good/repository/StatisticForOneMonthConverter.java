package com.erkan.reading.is.good.repository;

import java.math.BigDecimal;

public interface StatisticForOneMonthConverter {
    String getMonth();

    Long getTotalOrderCount();

    Long getTotalBookCount();

    BigDecimal getTotalPurchasedAmount();
}
