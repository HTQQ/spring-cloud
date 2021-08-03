package com.ht.controller;

import com.ht.model.Payment;
import com.ht.model.ResultBean;
import com.ht.service.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.*;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/2 16:04
 * @description:
 */
@RestController
public class Controller {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("payment/selectOne")
    public ResultBean<Payment> selectOne(Integer id){
        ResultBean<Payment> paymentResultBean = openFeignService.selectOne(id);
        return paymentResultBean;
    }
}
