package com.smart.ssm.service.impl;

import com.smart.ssm.entity.Product;
import com.smart.ssm.mapper.ProductMapper;
import com.smart.ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 10:51
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }
}
