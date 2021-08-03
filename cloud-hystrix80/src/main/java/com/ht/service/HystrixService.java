package com.ht.service;

import com.ht.model.ResultBean;
import org.springframework.stereotype.Service;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/8 14:36
 * @description:
 */
@Service
public class HystrixService implements HelloService{
    @Override
    public ResultBean get() {
        return new ResultBean(500,"调用失败");
    }

    @Override
    public ResultBean get1() {
        return new ResultBean(500,"调用失败");
    }
}
