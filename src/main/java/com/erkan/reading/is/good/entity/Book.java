package com.erkan.reading.is.good.entity;

import com.erkan.reading.is.good.controller.model.request.BookRequest;
import com.erkan.reading.is.good.controller.model.request.CreateBookRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @SequenceGenerator(schema = "EKO", name = "seqRigBookId", sequenceName = "seq_rig_book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigBookId")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
    private BookStock bookStock;

    private BigDecimal amount;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Book of(CreateBookRequest createBookRequest) {
        return Book.builder()
                .amount(createBookRequest.getAmount())
                .name(createBookRequest.getName())
                .build();
    }
}
