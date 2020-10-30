package com.smart.ssm.mapper;

import com.smart.ssm.entity.Cars;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 14:54
 */
public interface CarsMapper {

    /**
     * 添加用户
     *
     * @param cars 用户数据
     * @return 影响行数
     */
    int insertCarsProduct(Cars cars);

    /**
     * 查询用户购物车的某个商品数据
     *
     * @param userId    用户id
     * @param productId 商品id
     * @return 对象
     */
    Cars selectByUserIdAndProductId(@Param("userId") int userId, @Param("productId") int productId);

    /**
     * 查询用户购物车的所有商品信息
     *
     * @param userId 用户id
     * @return 数据集合
     */
    List<Cars> selectList(@Param("userId") int userId);

    /**
     * 更新购物车商品数量
     *
     * @param carsId 购物车id
     * @param num    数量
     * @return 影响行数
     */
    int updateById(@Param("carsId") int carsId, @Param("num") int num);

    /**
     * 删除购物车的某个商品
     *
     * @param carsId 购物车id
     * @return 影响行数
     */
    int deleteProductByCarsId(@Param("carsId") int carsId);

    /**
     * 修改用户商品数量
     *
     * @param carsId 购物车id
     * @param num 参数数量
     * @return 影响行数
     */
    int updateProductNumByCarsId(@Param("carsId") int carsId, @Param("num") int num);
}
