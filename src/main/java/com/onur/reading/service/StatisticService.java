package com.onur.reading.service;

import com.onur.reading.controller.model.response.MontlyReportResponse;
import com.onur.reading.controller.model.response.StatisticForOneMonth;
import com.onur.reading.repository.OrderHeaderRepository;
import com.onur.reading.repository.StatisticForOneMonthConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticService {

    private final OrderHeaderRepository orderHeaderRepository;

    public StatisticService(OrderHeaderRepository orderHeaderRepository) {
        this.orderHeaderRepository = orderHeaderRepository;
    }

    public MontlyReportResponse getMonthlyReport(Long customerId) {
        List<StatisticForOneMonthConverter> list = orderHeaderRepository.generateMonthlyReport(customerId);
        List<StatisticForOneMonth> statisticForOneMonth = list.stream()
                .map(StatisticForOneMonth::of).collect(Collectors.toList());
        return MontlyReportResponse.builder()
                .statisticForOneMonthList(statisticForOneMonth)
                .build();
    }
}
