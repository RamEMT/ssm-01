package com.smart.ssm.controller;

import com.smart.ssm.entity.Product;
import com.smart.ssm.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 10:48
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> list(){
        List<Product> all = null;
        try {
            all = productService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }
}
