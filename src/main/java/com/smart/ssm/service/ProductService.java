package com.smart.ssm.service;

import com.smart.ssm.entity.Product;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 10:50
 */
public interface ProductService {
    /**
     * 查询所有
     * @return
     */
    List<Product> findAll();
}
