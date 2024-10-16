package com.sk.testmvc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_generator")
    //@SequenceGenerator(name="order_id_generator", sequenceName = "order_id_seq")
    private Long id;
    //private Customer customer;

    @Column(nullable = false)
    private Double totalBill;

    private boolean discount;
}
