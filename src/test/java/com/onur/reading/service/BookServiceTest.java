package com.onur.reading.service;

import com.onur.reading.controller.model.request.CreateBookRequest;
import com.onur.reading.controller.model.response.BookResponse;
import com.onur.reading.entity.Book;
import com.onur.reading.exception.BookNotFoundException;
import com.onur.reading.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.prefs.BackingStoreException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    private static CreateBookRequest createBookRequest;

    @BeforeEach
    public void init() {
        createBookRequest = CreateBookRequest.builder()
                .authorName("Murat Mentes")
                .name("Ruhi Mucerret")
                .ISBN("987-7773-3333-0000")
                .quantity(1L)
                .build();
    }


    @Test
    public void createBookTest_whenSuccessRequest_thenReturnBookResponse() throws BackingStoreException {
        // GIVEN
        when(bookRepository.save(any(Book.class))).thenReturn(Book.builder()
                .id(500L)
                .name("Book123")
                .build());
        // WHEN
        BookResponse bookResponse = bookService.createBook(createBookRequest);
        // THEN
        assertThat(bookResponse.getId()).isEqualTo(500L);
        assertThat(bookResponse.getName()).isEqualTo("Book123");
    }
}
