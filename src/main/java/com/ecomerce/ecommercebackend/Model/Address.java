package com.ecomerce.ecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String addressLine1;
    @Column
    private String addressLine2;
    @Column
    private String city;
    @Column(name = "country", length = 75)
    private String country;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private LocalUser user;
    @OneToOne(mappedBy = "address",cascade = CascadeType.REMOVE,optional = false)
    private WebOrder order;

}
