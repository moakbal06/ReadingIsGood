package com.onur.reading.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onur.reading.controller.model.request.CreateBookRequest;
import com.onur.reading.controller.model.request.StockUpdateRequest;
import com.onur.reading.controller.model.response.BookResponse;
import com.onur.reading.service.BookService;
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

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;


    @Test
    void createBookShouldCreateWithCreatedStatus() throws Exception {
        CreateBookRequest createBookRequest = new CreateBookRequest();
        createBookRequest.setAuthorName("JaneDoe");
        createBookRequest.setISBN("ISBN");
        createBookRequest.setName("Name");
        createBookRequest.setQuantity(1L);
        String content = (new ObjectMapper()).writeValueAsString(createBookRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(201));
    }

    /**
     * Method under test: {@link BookController#updateBookStock(Long, StockUpdateRequest)}
     */
    @Test
    void updateBookStockShouldUpdateAndReturnResponse() throws Exception {
        when(this.bookService.updateStock((Long) any(), (StockUpdateRequest) any())).thenReturn(new BookResponse());

        StockUpdateRequest stockUpdateRequest = new StockUpdateRequest();
        stockUpdateRequest.setNewStock(1L);
        String content = (new ObjectMapper()).writeValueAsString(stockUpdateRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/books/{bookId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":null,\"name\":null,\"quantity\":null,\"bookStock\":null,\"isbn\":null}"));
    }
}

