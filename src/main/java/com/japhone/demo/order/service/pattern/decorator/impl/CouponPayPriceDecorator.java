package com.japhone.demo.order.service.pattern.decorator.impl;

import com.japhone.demo.common.enums.CouponTypeEnum;
import com.japhone.demo.model.bo.CouponBo;
import com.japhone.demo.model.bo.OrderBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/1
 * 优惠券装饰类
 */
public class CouponPayPriceDecorator extends PayPriceDecorator {

    Logger logger = LoggerFactory.getLogger(CouponPayPriceDecorator.class);

    public CouponPayPriceDecorator(PayPriceComponent component) {
        super(component);
    }

    @Override
    public void getPayPrice(OrderBo orderBo){
        super.getPayPrice(orderBo);

        logger.info("【优惠券】：{}", orderBo.getCoupon());
        couponPayPrice(orderBo);
    }

    /**
     * 计算优惠金额
     * @param orderBo
     */
    private void couponPayPrice(OrderBo orderBo) {
        CouponBo coupon = orderBo.getCoupon();
        boolean b = false;
        if(CouponTypeEnum.FULL_REDUCTION.getCode().compareTo(coupon.getType()) == 0) {//满减
            if(orderBo.getTotalPrice().compareTo(coupon.getPrice()) >= 0) {
                b = true;
            }
        }else if(CouponTypeEnum.DEDUCTION.getCode().compareTo(coupon.getType()) == 0) {//直降
            b = true;
        }else{
            logger.info("【优惠券】未知的优惠券类型");
        }

        if(b) {
            BigDecimal price = orderBo.getPayPrice().subtract(coupon.getReduction());
            if (price.compareTo(BigDecimal.ZERO) < 0) {
                price = BigDecimal.ZERO;
            }
            BigDecimal discountPrice = orderBo.getPayPrice().subtract(price);

            logger.info("【优惠券】优惠前价格：{}", orderBo.getPayPrice());
            orderBo.setPayPrice(price);
            orderBo.setDiscountPrice(discountPrice);

            logger.info("【优惠券】优惠后价格：{}，抵扣：{}", orderBo.getPayPrice(), orderBo.getDiscountPrice());
        }
    }
}
