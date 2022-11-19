package com.onur.reading.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MontlyReportResponse {
    private List<StatisticForOneMonth> statisticForOneMonthList;
}
