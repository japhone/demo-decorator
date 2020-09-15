package com.japhone.demo.order.service.pattern.decorator.impl;

import com.japhone.demo.model.bo.OrderBo;

/**
 * created by japhone on 2020/9/1
 */
public class PayPriceDecorator extends PayPriceComponent {

    protected PayPriceComponent component;

    public PayPriceDecorator(PayPriceComponent component){
        this.component = component;
    }

    public void getPayPrice(OrderBo orderBo) {
        //委派给构件
        component.getPayPrice(orderBo);
    }
}
