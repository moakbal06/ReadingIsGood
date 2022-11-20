package com.onur.reading.controller.model.response;

import com.onur.reading.entity.Book;
import com.onur.reading.entity.BookStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String name;
    private String ISBN;
    private Long quantity;
    private BookStock bookStock;

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .bookStock(book.getBookStock())
                .ISBN(book.getISBN())
                .quantity(book.getBookStock()==null ? 0 :book.getBookStock().getQuantity())
                .build();
    }
}
