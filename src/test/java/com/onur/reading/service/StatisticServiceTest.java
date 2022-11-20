package com.onur.reading.service;

import com.onur.reading.controller.model.response.MontlyReportResponse;
import com.onur.reading.controller.model.response.StatisticForOneMonth;
import com.onur.reading.repository.OrderHeaderRepository;
import com.onur.reading.repository.StatisticForOneMonthConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticServiceTest {


    @Mock
    private OrderHeaderRepository orderHeaderRepository;

    @InjectMocks
    private StatisticService statisticService;

    @Test
    void getMonthlyReport() {


        List<StatisticForOneMonthConverter> list = new ArrayList<>();

        StatisticForOneMonthConverter item1 = new StatisticForOneMonthConverter() {
            @Override
            public String getDate() {
                return "2022-11-11 19:00:00.0000";
            }

            @Override
            public Long getTotalOrderCount() {
                return 12L;
            }

            @Override
            public Long getTotalBookCount() {
                return 12L;
            }
        };
        list.add(item1);

        StatisticForOneMonth pojo = StatisticForOneMonth.of(item1);
        when(orderHeaderRepository.generateMonthlyReport(1L)).thenReturn(list);
        MontlyReportResponse monthlyReport = statisticService.getMonthlyReport(1L);


        assertTrue(monthlyReport.getStatisticForOneMonthList().size()>0);
        assertThat(monthlyReport.getStatisticForOneMonthList().get(0).getMonth(),is(pojo.getMonth()));
        assertThat(monthlyReport.getStatisticForOneMonthList().get(0).getTotalBookCount(),is(pojo.getTotalBookCount()));
        assertThat(monthlyReport.getStatisticForOneMonthList().get(0).getYear(),is(pojo.getYear()));


    }
}