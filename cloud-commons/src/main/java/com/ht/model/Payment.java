package com.ht.model;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2021-06-23 09:32:30
 */
public class Payment implements Serializable {

    private static final long serialVersionUID = 8797120187587161883L;
    private Integer id;
    /**
     * 订单号
     */
    private String serial;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}
