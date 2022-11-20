package com.onur.reading.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.onur.reading.controller.model.response.MontlyReportResponse;
import com.onur.reading.service.StatisticService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StatisticController.class})
@ExtendWith(SpringExtension.class)
class StatisticControllerTest {
    @Autowired
    private StatisticController statisticController;

    @MockBean
    private StatisticService statisticService;

    /**
     * Method under test: {@link StatisticController#getMonthlyStatistics(Long)}
     */
    @Test
    void testGetMonthlyStatistics() throws Exception {
        when(this.statisticService.getMonthlyReport((Long) any())).thenReturn(new MontlyReportResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/statistics/{customerId}/monthly-report",
                123L);
        MockMvcBuilders.standaloneSetup(this.statisticController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"statisticForOneMonthList\":null}"));
    }


}

