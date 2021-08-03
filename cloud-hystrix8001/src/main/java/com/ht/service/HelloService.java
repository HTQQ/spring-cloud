package com.ht.service;

import com.ht.model.ResultBean;
import org.springframework.stereotype.Service;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/7/8 10:43
 * @description:
 */

public interface HelloService {
    public ResultBean get();

    public ResultBean get1() throws InterruptedException;

    public ResultBean error(Integer id);
}
