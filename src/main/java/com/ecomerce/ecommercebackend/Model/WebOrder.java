package com.ecomerce.ecommercebackend.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private LocalUser user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="address_id",nullable = false)
    private Address address;
    @JsonIgnore
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<WebOrderQuantities> quantity = new ArrayList<>();

}
