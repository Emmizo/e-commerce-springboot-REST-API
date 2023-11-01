package com.ecomerce.ecommercebackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER,optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, unique = true)

    private Product product;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
