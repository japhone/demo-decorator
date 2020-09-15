package com.japhone.demo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/14
 */
public class Goods implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 商品sku id
     */
    private Long skuId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", skuId=" + skuId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
