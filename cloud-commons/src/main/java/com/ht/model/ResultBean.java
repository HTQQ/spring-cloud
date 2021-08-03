package com.ht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: ht
 * @email: 893698116@qq.com
 * @date: 2021/6/28 8:05
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 8945821630644939194L;

    public ResultBean(Integer code,String message){
        this(code,message,null);
    }

    private Integer code;

    private String message;

    private T data;




}
