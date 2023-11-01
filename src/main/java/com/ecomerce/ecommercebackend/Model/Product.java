package com.ecomerce.ecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name="short_description", nullable = false)
    private String shortDescription;

    @Column(name="long_description", nullable = false)
    private String longDescription;

    @Column(name="price", nullable = false)
    private Double price;

    @OneToOne(mappedBy = "product",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE,optional = false)

    private Inventory inventory;

}
