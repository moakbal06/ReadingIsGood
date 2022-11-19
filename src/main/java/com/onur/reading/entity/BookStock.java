package com.onur.reading.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "book_stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookStock {
    @Id
    @SequenceGenerator(schema = "reading", name = "seqRigBookStockId", sequenceName = "seq_rig_book_stock_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigBookStockId")
    private Long id;

    private Long quantity;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
