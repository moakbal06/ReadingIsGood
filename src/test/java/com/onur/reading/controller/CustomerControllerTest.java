package com.onur.reading.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onur.reading.controller.model.request.CustomerRequest;
import com.onur.reading.service.CustomerService;
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

@ContextConfiguration(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    /**
     * Method under test: {@link CustomerController#createCustomer(CustomerRequest)}
     */
    @Test
    void createCustomerShouldCreateAndReturnCreatedStatus() throws Exception {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(customerRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(201));
    }
}

