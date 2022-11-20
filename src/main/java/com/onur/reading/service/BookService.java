package com.onur.reading.service;

import com.onur.reading.controller.model.request.CreateBookRequest;
import com.onur.reading.controller.model.request.StockUpdateRequest;
import com.onur.reading.controller.model.response.BookResponse;
import com.onur.reading.entity.Book;
import com.onur.reading.entity.BookStock;
import com.onur.reading.exception.BookNotFoundException;
import com.onur.reading.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.prefs.BackingStoreException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(CreateBookRequest createBookRequest) throws BackingStoreException {
        validateForCreate(createBookRequest);
        Book book = Book.of(createBookRequest);
        BookStock bookStock = BookStock.builder()
                .book(book)
                .quantity(createBookRequest.getQuantity())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        book.setBookStock(bookStock);
        return BookResponse.of(bookRepository.save(book));
    }

    private void validateForCreate(CreateBookRequest createBookRequest) throws BackingStoreException {

        if(createBookRequest.getQuantity() < 0){
            throw new BackingStoreException("You cannot create a book with negative quantity");
        }

    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public BookResponse updateStock(Long bookId, StockUpdateRequest stockUpdateRequest) throws BackingStoreException {
        validateForUpdate(stockUpdateRequest);
        Book bookById = getBookById(bookId);
        BookStock bookStock = bookById.getBookStock();
        bookStock.setQuantity(stockUpdateRequest.getNewStock());
        Book savedBook = bookRepository.save(bookById);

        return BookResponse.of(savedBook);
    }

    private void validateForUpdate(StockUpdateRequest stockUpdateRequest) throws BackingStoreException {
        if(stockUpdateRequest.getNewStock() < 0){
            throw new BackingStoreException("You cannot create a book with negative quantity");
        }

    }
}
