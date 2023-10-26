package com.ecomerce.ecommercebackend.api.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.ecommercebackend.api.model.LoginBody;
import com.ecomerce.ecommercebackend.api.model.LoginResponse;
import com.ecomerce.ecommercebackend.api.model.RegistrationBody;
import com.ecomerce.ecommercebackend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

private UserService userService;


    public AuthenticationController(UserService userService) {
    this.userService = userService;
}


    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try{
       userService.registerUser(registrationBody);
          return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody){
        String jwt = userService.loginUser(loginBody);
        if(jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
             LoginResponse response = new LoginResponse();
             response.setJwt(jwt);
             return ResponseEntity.ok(response);
        }
    }
}
