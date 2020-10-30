package com.smart.ssm.request;

import lombok.Data;

/**
 * @Author: Ram
 * @Since: 2020.10.30 14:37
 *
 *  购物车参数实体类
 */
@Data
public class CarsRequestParams {
    private int userId;
    private int num;
    private int productId;
}
