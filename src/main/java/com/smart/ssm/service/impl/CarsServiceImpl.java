package com.smart.ssm.service.impl;

import com.smart.ssm.entity.Cars;
import com.smart.ssm.mapper.CarsMapper;
import com.smart.ssm.request.CarsRequestParams;
import com.smart.ssm.service.CarsService;
import com.smart.ssm.utils.ColaBeanUtils;
import com.smart.ssm.vo.CarsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Ram
 * @Since: 2020.10.30 14:53
 * <p>
 * vo对象一般作为 service 层的返回值
 */
@Service
public class CarsServiceImpl implements CarsService {
    @Resource
    private CarsMapper carsMapper;

    @Override
    public int addCars(CarsRequestParams carsRequestParams) {
        int temp = 0;
        try {
            //请求参数与持久化对象的转化问题
            Cars car = carsMapper.selectByUserIdAndProductId(carsRequestParams.getUserId(), carsRequestParams.getProductId());
            //判断用户的购物车中是否存在该条记录,不为空说明已经存在
            if (car != null) {
                int num = car.getNum() + carsRequestParams.getNum();
                temp = carsMapper.updateById(car.getCarsId(), num);
            } else {
                Cars cars = new Cars();
                //BeanUtils.copyProperties(参数1, 参数2)
                //作用：将对象的属性拷贝到另一个对象
                //参数1 -- 要拷贝的对象，参数2 -- 目标对象
                BeanUtils.copyProperties(carsRequestParams, cars);
                temp = carsMapper.insertCarsProduct(cars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public List<CarsVO> findAll(int uid) {
        //获取购物车所有信息
        List<Cars> cars = carsMapper.selectList(uid);
        //BeanUtils 支持对象 不支持list
        //将 Cars 对象转换为 CarsVO 对象
        return ColaBeanUtils.copyListProperties(cars, CarsVO::new);
    }

    @Override
    public int delProduct(int carsId) {
        return carsMapper.deleteProductByCarsId(carsId);
    }

    @Override
    public int updateProductNum(int carsId, int num) {
        return carsMapper.updateProductNumByCarsId(carsId, num);
    }
}
