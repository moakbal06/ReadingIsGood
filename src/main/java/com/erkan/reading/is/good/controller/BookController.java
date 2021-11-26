package com.erkan.reading.is.good.controller;

import com.erkan.reading.is.good.controller.model.request.BookRequest;
import com.erkan.reading.is.good.controller.model.request.CreateBookRequest;
import com.erkan.reading.is.good.controller.model.response.BookResponse;
import com.erkan.reading.is.good.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest createBookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(createBookRequest));
    }
}
