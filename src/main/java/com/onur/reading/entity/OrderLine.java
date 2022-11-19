package com.onur.reading.entity;

import com.onur.reading.enums.OrderLineStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "order_lines")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLine {
    @Id
    @SequenceGenerator(schema = "reading", name = "seqRigOrderLineId", sequenceName = "seq_rig_order_line_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigOrderLineId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "header_id")
    private OrderHeader header;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Long quantity;

    @Enumerated(EnumType.STRING)
    private OrderLineStatus orderStatus;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
