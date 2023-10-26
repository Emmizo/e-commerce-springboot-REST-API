package com.ecomerce.ecommercebackend.Model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ecomerce.ecommercebackend.Model.LocalUser;

public interface LocalUserDao extends CrudRepository<LocalUser, Long>{
   Optional<LocalUser>findByUsernameIgnoreCase(String username);
   Optional<LocalUser>findByEmailIgnoreCase(String email);
}
