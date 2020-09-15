package com.japhone.demo.order.service;

import com.japhone.demo.model.entity.Coupon;

/**
 * created by japhone on 2020/9/1
 * 优惠券
 */
public interface CouponService {

    /**
     * 根据优惠券编号获取优惠券详情
     * @param code
     * @return
     */
    Coupon getByCode(String code);

}
