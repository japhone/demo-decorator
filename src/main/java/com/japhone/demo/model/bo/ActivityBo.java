package com.japhone.demo.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/1
 * 折扣活动
 */
public class ActivityBo implements Serializable {

    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 商品sku id
     */
    private Long skuId;
    /**
     * 折扣
     */
    private BigDecimal discount;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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
        return "ActivityBo{" +
                "activityId=" + activityId +
                ", skuId=" + skuId +
                ", discount=" + discount +
                '}';
    }
}
