package com.ht.service.controller;

import com.ht.service.IMessageProvide;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/8/12 11:03
 * @description:
 */
@RestController
public class MessageProvideController {

    @Resource
    private IMessageProvide iMessageProvide;

    @GetMapping("/send")
    public void Send() {
        iMessageProvide.send();
    }
}
