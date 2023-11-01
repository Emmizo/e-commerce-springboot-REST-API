package com.ecomerce.ecommercebackend.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ecomerce.ecommercebackend.Model.Product;
import com.ecomerce.ecommercebackend.Model.dao.ProductDao;

@Service
public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts(){
        return productDao.findAll();
    }

}
