package com.erkan.reading.is.good.controller.model.response;

import com.erkan.reading.is.good.entity.Book;
import com.erkan.reading.is.good.entity.Customer;
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

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }
}
