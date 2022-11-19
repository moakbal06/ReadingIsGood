package com.onur.reading.controller;

import com.onur.reading.controller.model.response.MontlyReportResponse;
import com.onur.reading.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/{customerId}/monthly-report")
    public ResponseEntity<MontlyReportResponse> getMonthlyStatistics(@PathVariable Long customerId) {
        return ResponseEntity.ok(statisticService.getMonthlyReport(customerId));
    }
}
