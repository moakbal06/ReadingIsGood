package com.onur.reading.entity;

import com.onur.reading.controller.model.request.CreateBookRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @SequenceGenerator(schema = "reading", name = "seqRigBookId", sequenceName = "seq_rig_book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigBookId")
    private Long id;

    private String name;

    private String ISBN;

    private String author;

    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
    private BookStock bookStock;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Book of(CreateBookRequest createBookRequest) {
        return Book.builder()
                .name(createBookRequest.getName())
                .ISBN(createBookRequest.getISBN())
                .build();
    }
}
