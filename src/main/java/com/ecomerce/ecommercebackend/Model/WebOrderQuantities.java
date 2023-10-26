package com.ecomerce.ecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "web_order_quantities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebOrderQuantities {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(name ="quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id",nullable = false)
    private WebOrder order;

}
