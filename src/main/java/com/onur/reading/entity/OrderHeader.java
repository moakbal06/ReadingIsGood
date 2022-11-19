package com.onur.reading.entity;

import com.onur.reading.enums.OrderHeaderStatus;
import com.onur.reading.enums.OrderLineStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "order_headers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderHeader {
    @Id
    @SequenceGenerator(schema = "reading", name = "seqRigOrderHeaderId", sequenceName = "seq_rig_order_header_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigOrderHeaderId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL)
    private List<OrderLine> lines;

    private Long totalQuantity;

    @Enumerated(EnumType.STRING)
    private OrderHeaderStatus orderStatus;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

}
