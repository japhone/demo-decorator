package com.japhone.demo.order.service.pattern.factory.impl;

import com.japhone.demo.model.bo.CouponBo;
import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import com.japhone.demo.model.entity.Coupon;
import com.japhone.demo.order.service.CouponService;
import com.japhone.demo.order.service.pattern.decorator.impl.CouponPayPriceDecorator;
import com.japhone.demo.order.service.pattern.decorator.impl.PayPriceComponent;
import com.japhone.demo.order.service.pattern.factory.IPayPriceComponentFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * created by japhone on 2020/9/15
 * 生产优惠券构件类
 */
@Component
public class CouponPayPriceComponent implements IPayPriceComponentFactory {

    @Resource
    private CouponService couponService;

    @Override
    public PayPriceComponent generatePayPriceComponent(SubmitOrderBo submitOrder, OrderBo order, PayPriceComponent component) {
        if(submitOrder.getCoupon() != null) {//如果使用优惠券
            Coupon coupon = couponService.getByCode(submitOrder.getCoupon().getCode());
            CouponBo couponBo = new CouponBo();
            BeanUtils.copyProperties(coupon, couponBo);
            order.setCoupon(couponBo);
            return component = new CouponPayPriceDecorator(component);
        }
        return component;
    }
}
