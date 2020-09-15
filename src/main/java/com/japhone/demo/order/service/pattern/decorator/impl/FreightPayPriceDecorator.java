package com.japhone.demo.order.service.pattern.decorator.impl;

import com.japhone.demo.model.bo.OrderBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/1
 * 运费装饰类
 */
public class FreightPayPriceDecorator extends PayPriceDecorator {

    Logger logger = LoggerFactory.getLogger(FreightPayPriceDecorator.class);

    public FreightPayPriceDecorator(PayPriceComponent component) {
        super(component);
    }

    @Override
    public void getPayPrice(OrderBo orderBo){
        super.getPayPrice(orderBo);

        logger.info("【运费】：{}", orderBo.getFreight());
        freightPayPrice(orderBo);
    }

    /**
     * 计算折扣金额
     * @param orderBo
     */
    private void freightPayPrice(OrderBo orderBo) {
        BigDecimal freight = orderBo.getFreight().getFreight();
        if(freight != null && freight.compareTo(BigDecimal.ZERO) > 0) {
            logger.info("【运费】运费后价格：{}", orderBo.getPayPrice());

            orderBo.setPayPrice(orderBo.getPayPrice().add(orderBo.getFreight().getFreight()));
            orderBo.setTotalPrice(orderBo.getTotalPrice().add(orderBo.getFreight().getFreight()));

            logger.info("【运费】运费后价格：{}", orderBo.getPayPrice());
        }
    }
}
