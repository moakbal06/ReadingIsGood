package com.erkan.reading.is.good.service;

import com.erkan.reading.is.good.controller.model.request.CreateBookRequest;
import com.erkan.reading.is.good.controller.model.response.BookResponse;
import com.erkan.reading.is.good.entity.Author;
import com.erkan.reading.is.good.entity.Book;
import com.erkan.reading.is.good.exception.BookNotFoundException;
import com.erkan.reading.is.good.repository.AuthorRepository;
import com.erkan.reading.is.good.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

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

    @Mock
    private AuthorRepository authorRepository;

    private static CreateBookRequest createBookRequest;

    @BeforeEach
    public void init() {
        createBookRequest = CreateBookRequest.builder()
                .authorId(123L)
                .amount(new BigDecimal("100"))
                .name("BOOK 1")
                .quantity(1L)
                .build();
    }

    @Test()
    public void createBookTest_whenAuthorIdIsNotFound_thenThrowBookNotFoundException() {
        // GIVEN
        when(authorRepository.findById(createBookRequest.getAuthorId()))
                .thenReturn(Optional.empty());
        // WHEN THEN
        assertThrows(BookNotFoundException.class, () -> bookService.createBook(createBookRequest));
    }

    @Test
    public void createBookTest_whenSuccessRequest_thenReturnBookResponse() {
        // GIVEN
        when(authorRepository.findById(createBookRequest.getAuthorId()))
                .thenReturn(Optional.of(Author.builder()
                        .id(1L)
                        .name("Erkan").build()));
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
