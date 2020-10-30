package com.smart.ssm.mapper;

import com.smart.ssm.entity.Product;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 10:52
 */
public interface ProductMapper {
    /**
     * 获取所有数据
     * @return
     */
    List<Product> selectAll();
}
