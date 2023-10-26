package com.ecomerce.ecommercebackend.api.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String jwt;
}
