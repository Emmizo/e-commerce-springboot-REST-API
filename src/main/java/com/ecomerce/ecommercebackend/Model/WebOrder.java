package com.ecomerce.ecommercebackend.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "web_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private LocalUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name="address_id",nullable = false)
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<WebOrderQuantities> quantity = new ArrayList<>();

}
