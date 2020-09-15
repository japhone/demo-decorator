package com.japhone.demo.model.bo;

import java.io.Serializable;
import java.util.List;

/**
 * created by japhone on 2020-08-26
 * 提交订单对象
 */
public class SubmitOrderBo implements Serializable {

    /**
     * 收货地址
     */
    private AddressBo address;

    /**
     * 商品
     */
    private List<GoodsBo> goods;

    /**
     * 优惠券
     */
    private CouponBo coupon;

    public AddressBo getAddress() {
        return address;
    }

    public void setAddress(AddressBo address) {
        this.address = address;
    }

    public List<GoodsBo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBo> goods) {
        this.goods = goods;
    }

    public CouponBo getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponBo coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "SubmitOrderBo{" +
                "address=" + address +
                ", goods=" + goods +
                ", coupon=" + coupon +
                '}';
    }
}
