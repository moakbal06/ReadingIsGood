package com.onur.reading.controller.model.response;

import com.onur.reading.entity.Book;
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

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .ISBN(book.getISBN())
                .quantity(book.getBookStock().getQuantity())
                .build();
    }
}
