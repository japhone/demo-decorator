package com.japhone.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/14
 * 活动
 */
public class Activity implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 商品sku
     */
    private Long skuId;

    /**
     * 活动折扣
     */
    private BigDecimal discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skuId=" + skuId +
                ", discount=" + discount +
                '}';
    }
}
