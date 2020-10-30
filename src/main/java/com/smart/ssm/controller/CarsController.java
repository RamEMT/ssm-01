package com.smart.ssm.controller;

import com.smart.ssm.entity.Cars;
import com.smart.ssm.request.CarsRequestParams;
import com.smart.ssm.service.CarsService;
import com.smart.ssm.utils.ResponseEntity;
import com.smart.ssm.vo.CarsVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Ram
 * @Since 2020.10.30 14:27
 */
@RestController
@RequestMapping("/car")
public class CarsController {
    @Resource
    CarsService carsService;

    /**
     * 查询用户购物车所有商品信息
     *
     * @param userId 用户id
     * @return 数据对象
     */
    @GetMapping("/list")
    ResponseEntity<List<CarsVO>> list(@RequestParam("userId") int userId) {
        try {
            List<CarsVO> voList = carsService.findAll(userId);
            //返回获取的数据
            return ResponseEntity.success(voList);
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }

    /**
     * 添加购物车
     *
     * @param carsRequestParams 数据对象
     * @return 数据对象
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(CarsRequestParams carsRequestParams) {
        try {
            //获取添加数据的结果
            int count = carsService.addCars(carsRequestParams);
            //如果 count > 0,则说明添加成功
            if (count > 0) {
                //返回成功的方法
                return ResponseEntity.success(true);
            } else {
                //返回失败的方法
                return ResponseEntity.error();
            }
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }

    /**
     * 删除购物车
     *
     * @param carsId 购物车id
     * @return 影响行数
     */
    @PutMapping("/del")
    public ResponseEntity<Boolean> del(@RequestParam int carsId) {
        try {
            int count = carsService.delProduct(carsId);
            //如果 count > 0,则说明删除成功
            if (count > 0) {
                //返回成功的方法
                return ResponseEntity.success(true);
            } else {
                //返回失败的方法
                return ResponseEntity.error();
            }
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateNum(@RequestParam int carsId, @RequestParam int num) {
        try {
            int count = carsService.updateProductNum(carsId, num);
            //如果 count > 0,则说明修改成功
            if (count > 0) {
                //返回成功的方法
                return ResponseEntity.success(true);
            } else {
                //返回失败的方法
                return ResponseEntity.error();
            }
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }
}
