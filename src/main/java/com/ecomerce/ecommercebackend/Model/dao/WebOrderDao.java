package com.ecomerce.ecommercebackend.Model.dao;

import org.springframework.data.repository.ListCrudRepository;

import com.ecomerce.ecommercebackend.Model.LocalUser;
import com.ecomerce.ecommercebackend.Model.WebOrder;
import java.util.List;


public interface WebOrderDao extends ListCrudRepository<WebOrder, Long>{
    List<WebOrder> findByUser(LocalUser user);
}
