package com.onur.reading.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reset_password")
public class EntityResetPassword extends AbstractAuditableEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    @Column
    private EnumResetPassword status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;



}
