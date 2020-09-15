package com.japhone.demo.order.service.pattern.factory;

import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import com.japhone.demo.order.service.pattern.decorator.impl.PayPriceComponent;

/**
 * created by japhone on 2020/9/15
 * 实际支付价格构件工厂类接口
 */
public interface IPayPriceComponentFactory {

    /**
     * 生成构件
     * @param submitOrder
     * @param order
     * @param component
     * @return
     */
    PayPriceComponent generatePayPriceComponent(SubmitOrderBo submitOrder, OrderBo order, PayPriceComponent component);

}
