package com.onur.reading.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onur.reading.controller.model.request.OrderRequest;
import com.onur.reading.controller.model.response.OrderResponse;
import com.onur.reading.service.OrderService;

import java.time.LocalDateTime;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderController#createOrder(OrderRequest)}
     */
    @Test
    void createOrderShouldCreateAndReturnCreatedStatus() throws Exception {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setBookRequestList(new ArrayList<>());
        orderRequest.setCustomerId(123L);
        String content = (new ObjectMapper()).writeValueAsString(orderRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(201));
    }

    /**
     * Method under test: {@link OrderController#getOrderById(Long)}
     */
    @Test
    void getOrderByIdShouldReturnGivenResponse() throws Exception {
        when(this.orderService.getOrderById((Long) any())).thenReturn(new OrderResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orders/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":null,\"customer\":null,\"lines\":null,\"totalQuantity\":null,\"orderStatus\":null}"));
    }



    /**
     * Method under test: {@link OrderController#getAllOrdersOfCustomer(Long)}
     */
    @Test
    void getAllOrdersOfCustomerShouldReturnGivenResponse() throws Exception {
        ArrayList<OrderResponse> orderResponseList = new ArrayList<>();
        orderResponseList.add(new OrderResponse());
        when(this.orderService.getOrdersFromCustomer((Long) any())).thenReturn(orderResponseList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orders/getOrdersByCustomerId/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"id\":null,\"customer\":null,\"lines\":null,\"totalQuantity\":null,\"orderStatus\":null}]"));
    }

    /**
     * Method under test: {@link OrderController#getOrderByDates(LocalDateTime, LocalDateTime)}
     */
    @Test
    void getOrderByDatesShouldReturnBadRequestWhenGivenInvalidParamters() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/orders/interval");
        MockHttpServletRequestBuilder paramResult = getResult.param("endDate", String.valueOf((Object) null));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("startDate", String.valueOf((Object) null));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

