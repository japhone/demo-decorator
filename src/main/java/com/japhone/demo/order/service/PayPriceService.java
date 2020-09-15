package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;

/**
 * created by japhone on 2020/9/15
 * 实际支付金额
 */
public interface PayPriceService {

    /**
     * 计算实际支付金额
     * @param submitOrder
     * @param order
     */
    void calculation(SubmitOrderBo submitOrder, OrderBo order);

}
