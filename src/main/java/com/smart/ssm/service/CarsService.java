package com.smart.ssm.service;

import com.smart.ssm.request.CarsRequestParams;
import com.smart.ssm.vo.CarsVO;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 14:52
 * <p>
 * vo对象一般在开发中作为 service 层的返回值
 */
public interface CarsService {
    /**
     * 添加购物车商品
     *
     * @param carsRequestParams 商品参数
     * @return 影响行数
     */
    int addCars(CarsRequestParams carsRequestParams);

    /**
     * 查询用户购物车的所有商品
     *
     * @param uid 用户id
     * @return 数据结合
     */
    List<CarsVO> findAll(int uid);

    /**
     * 删除用户商品信息
     *
     * @param carsId 购物车id
     * @return 影响行数
     */
    int delProduct(int carsId);

    /**
     * 更新购物车商品数量信息
     *
     * @param carsId 参数id
     * @param num 参数数量
     * @return 影响行数
     */
    int updateProductNum(int carsId, int num);
}
