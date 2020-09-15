package com.japhone.demo.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * created by japhone on 2020/9/1
 * 订单业务类
 */
public class OrderBo implements Serializable {

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;

    /**
     * 实际支付金额
     */
    private BigDecimal payPrice;

    /**
     * 抵扣金额
     */
    private BigDecimal discountPrice;

    /**
     * 商品
     */
    private List<GoodsBo> goodsList;

    /**
     * 优惠券信息
     */
    private CouponBo coupon;

    /**
     * 折扣活动
     */
    private List<ActivityBo> activityList;

    /**
     * 运费
     */
    private FreightBo freight;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public List<GoodsBo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsBo> goodsList) {
        this.goodsList = goodsList;
    }

    public CouponBo getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponBo coupon) {
        this.coupon = coupon;
    }

    public List<ActivityBo> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityBo> activityList) {
        this.activityList = activityList;
    }

    public FreightBo getFreight() {
        return freight;
    }

    public void setFreight(FreightBo freight) {
        this.freight = freight;
    }

    @Override
    public String toString() {
        return "OrderBo{" +
                "orderNo='" + orderNo + '\'' +
                ", totalPrice=" + totalPrice +
                ", payPrice=" + payPrice +
                ", discountPrice=" + discountPrice +
                ", goodsList=" + goodsList +
                ", coupon=" + coupon +
                ", activityList=" + activityList +
                ", freight=" + freight +
                '}';
    }
}
