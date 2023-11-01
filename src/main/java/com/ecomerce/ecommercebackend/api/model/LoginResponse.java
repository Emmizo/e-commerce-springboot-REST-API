package com.ecomerce.ecommercebackend.api.model;

import com.ecomerce.ecommercebackend.Model.LocalUser;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String jwt;
    private LocalUser user;
}
