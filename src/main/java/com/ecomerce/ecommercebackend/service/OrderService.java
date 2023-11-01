package com.ecomerce.ecommercebackend.service;


import org.springframework.stereotype.Service;
import java.util.List;
import com.ecomerce.ecommercebackend.Model.LocalUser;
import com.ecomerce.ecommercebackend.Model.WebOrder;
import com.ecomerce.ecommercebackend.Model.dao.WebOrderDao;

@Service
public class OrderService {
    private WebOrderDao webOrderDao;

    public OrderService(WebOrderDao webOrderDao) {
        this.webOrderDao = webOrderDao;
    }

    public List<WebOrder> getOrders(LocalUser user){
        return webOrderDao.findByUser(user);
    }
}
