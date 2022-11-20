package com.onur.reading.controller;

import com.onur.reading.controller.model.request.CreateBookRequest;
import com.onur.reading.controller.model.request.StockUpdateRequest;
import com.onur.reading.controller.model.response.BookResponse;
import com.onur.reading.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.prefs.BackingStoreException;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest createBookRequest) throws BackingStoreException {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(createBookRequest));
    }
    @PutMapping(path = "/{bookId}")
    public ResponseEntity<BookResponse> updateBookStock(@PathVariable Long bookId, @RequestBody StockUpdateRequest stockUpdateRequest) throws BackingStoreException {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.updateStock(bookId,stockUpdateRequest));
    }
}
