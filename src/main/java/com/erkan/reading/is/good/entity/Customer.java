package com.erkan.reading.is.good.entity;

import com.erkan.reading.is.good.controller.model.request.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @SequenceGenerator(schema = "EKO", name = "seqRigCustomerId", sequenceName = "seq_rig_customer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRigCustomerId")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<OrderHeader> orderHeaderList;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Customer of(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
