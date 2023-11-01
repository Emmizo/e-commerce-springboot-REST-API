package com.ecomerce.ecommercebackend.Model.dao;

import org.springframework.data.repository.ListCrudRepository;

import com.ecomerce.ecommercebackend.Model.Product;

public interface ProductDao extends ListCrudRepository<Product, Long>{
    
}
