package com.ecomerce.ecommercebackend.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {
    
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;

}
