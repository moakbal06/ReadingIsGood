package com.erkan.reading.is.good.service;

import com.erkan.reading.is.good.controller.model.request.CreateBookRequest;
import com.erkan.reading.is.good.controller.model.response.BookResponse;
import com.erkan.reading.is.good.entity.Author;
import com.erkan.reading.is.good.entity.Book;
import com.erkan.reading.is.good.entity.BookStock;
import com.erkan.reading.is.good.exception.BookNotFoundException;
import com.erkan.reading.is.good.repository.AuthorRepository;
import com.erkan.reading.is.good.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public BookResponse createBook(CreateBookRequest createBookRequest) {
        Author author = authorRepository.findById(createBookRequest.getAuthorId())
                .orElseThrow(BookNotFoundException::new);
        Book book = Book.of(createBookRequest);
        book.setAuthor(author);
        BookStock bookStock = BookStock.builder()
                .book(book)
                .quantity(createBookRequest.getQuantity())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        book.setBookStock(bookStock);
        return BookResponse.of(bookRepository.save(book));
    }
}
