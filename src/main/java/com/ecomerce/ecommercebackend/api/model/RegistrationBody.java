package com.ecomerce.ecommercebackend.api.model;

import jakarta.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationBody {
    
    @NotNull
    @NotBlank
   @Size(min=3,max=32, message="minimum or max  length should be at least doesn't match")
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(min=6,max=32, message="minimum length should be at least 6")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private String password;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
}
