package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.SubmitOrderBo;

/**
 * created by japhone on 2020-08-26
 */
public interface OrderService {

    /**
     * 提交订单
     * @param submitOrder
     */
    void submit(SubmitOrderBo submitOrder);

}
