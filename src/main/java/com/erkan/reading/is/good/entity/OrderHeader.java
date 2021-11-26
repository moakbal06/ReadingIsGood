package com.erkan.reading.is.good.entity;

import com.erkan.reading.is.good.controller.model.request.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

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
    @SequenceGenerator(schema = "EKO", name = "seqRigOrderHeaderId", sequenceName = "seq_rig_order_header_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigOrderHeaderId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL)
    private List<OrderLine> lines;

    private BigDecimal totalAmount;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

}
