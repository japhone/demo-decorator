package com.japhone.demo.order.service.pattern.decorator;

import com.japhone.demo.model.bo.OrderBo;

/**
 * created by japhone on 2020/9/1
 * 支付金额装饰模式接口
 */
public interface IPayPriceComponent {

    void getPayPrice(OrderBo orderBo);

}
