package com.japhone.demo.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020-08-26
 * 商品
 */
public class GoodsBo implements Serializable {

    /**
     * 商品sku id
     */
    private Long skuId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 价格
     */
    private BigDecimal price;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsBo{" +
                "skuId=" + skuId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
