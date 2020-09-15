package com.japhone.demo.order.service.pattern.decorator.impl;

import com.japhone.demo.model.bo.GoodsBo;
import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.order.service.pattern.decorator.IPayPriceComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by japhone on 2020/9/1
 * 计算订单实际支付金额
 */
public class PayPriceComponent implements IPayPriceComponent {

    Logger logger = LoggerFactory.getLogger(PayPriceComponent.class);

    @Override
    public void getPayPrice(OrderBo orderBo) {
        List<GoodsBo> goodsList = orderBo.getGoodsList();
        BigDecimal totalPrice = BigDecimal.ZERO;
        if(goodsList != null && goodsList.size() > 0) {
            /**
             * 订单的总价格等于每个商品的价格乘以数量之和
             */
            for(GoodsBo goods : goodsList) {
                totalPrice = totalPrice.add(goods.getPrice().multiply(BigDecimal.valueOf(goods.getQuantity())));
            }
        }
        orderBo.setPayPrice(totalPrice);
        orderBo.setTotalPrice(totalPrice);
        orderBo.setDiscountPrice(BigDecimal.ZERO);

        logger.info("装饰前：订单{}，总金额{}，实际支付金额{}", orderBo.getOrderNo(), orderBo.getTotalPrice(), orderBo.getPayPrice());
    }
}
