package com.smart.ssm.entity;

import lombok.Data;

/**
 * @Author Ram
 */
@Data
public class Cars {
    /**
     *
     */
    private Integer carsId;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品的外键
     */
    private Integer productId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 0表示正常 1表示删除
     */
    private Integer status;
}

