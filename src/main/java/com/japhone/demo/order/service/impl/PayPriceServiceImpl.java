package com.japhone.demo.order.service.impl;

import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import com.japhone.demo.order.service.PayPriceService;
import com.japhone.demo.order.service.pattern.decorator.impl.PayPriceComponent;
import com.japhone.demo.order.service.pattern.factory.impl.ActivityPayPriceComponent;
import com.japhone.demo.order.service.pattern.factory.impl.CouponPayPriceComponent;
import com.japhone.demo.order.service.pattern.factory.impl.FreightPayPriceComponent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by japhone on 2020/9/15
 */
@Service
public class PayPriceServiceImpl implements PayPriceService {

    @Resource
    private ActivityPayPriceComponent activityPayPriceComponent;
    @Resource
    private CouponPayPriceComponent couponPayPriceComponent;
    @Resource
    private FreightPayPriceComponent freightPayPriceComponent;

    @Override
    public void calculation(SubmitOrderBo submitOrder, OrderBo order) {
        PayPriceComponent component = new PayPriceComponent();

        /**装饰折扣活动**/
        component = activityPayPriceComponent.generatePayPriceComponent(submitOrder, order, component);

        /**装饰优惠券**/
        component = couponPayPriceComponent.generatePayPriceComponent(submitOrder, order, component);

        /**装饰运费**/
        component = freightPayPriceComponent.generatePayPriceComponent(submitOrder, order, component);

        /**计算实际支付价格**/
        component.getPayPrice(order);
    }
}
