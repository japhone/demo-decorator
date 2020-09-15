package com.japhone.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/14
 */
public class Coupon implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 优惠券编号
     */
    private String code;

    /**
     * 优惠券类型
     */
    private Integer type;

    /**
     * 满足多少金额
     */
    private BigDecimal price;

    /**
     * 优惠金额
     */
    private BigDecimal reduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", reduction=" + reduction +
                '}';
    }
}
