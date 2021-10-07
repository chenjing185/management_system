package com.itcast.ssm.service;

import com.itcast.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(int page,int size) throws Exception;

    Product save(Product product) throws Exception;
}
