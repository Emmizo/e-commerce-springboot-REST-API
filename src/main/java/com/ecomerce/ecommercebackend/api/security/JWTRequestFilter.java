package com.ecomerce.ecommercebackend.api.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.ecomerce.ecommercebackend.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTRequestFilter  extends OncePerRequestFilter{

     private JWTService jwtService;

    public JWTRequestFilter(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String tokenHeader = request.getHeader("Authorization");
                if(tokenHeader != null && tokenHeader.startsWith("Bearer")){
                    String token = tokenHeader.substring(7);
                    try{
                    String username = jwtService.getUsername(token);
                    }catch(JWTDecodeException ex){
                        
                    }
                }
                filterChain.doFilter(request, response);
       
    }
    
}
