package com.japhone.demo.order.service.pattern.decorator.impl;

import com.japhone.demo.model.bo.ActivityBo;
import com.japhone.demo.model.bo.GoodsBo;
import com.japhone.demo.model.bo.OrderBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by japhone on 2020/9/1
 * 折扣活动装饰类
 */
public class ActivityPayPriceDecorator extends PayPriceDecorator {

    Logger logger = LoggerFactory.getLogger(ActivityPayPriceDecorator.class);

    public ActivityPayPriceDecorator(PayPriceComponent component) {
        super(component);
    }

    @Override
    public void getPayPrice(OrderBo orderBo){
        super.getPayPrice(orderBo);

        logger.info("【折扣活动】：{}", orderBo.getActivityList());
        discountPayPrice(orderBo);
    }

    /**
     * 计算折扣金额
     * @param orderBo
     */
    private void discountPayPrice(OrderBo orderBo) {

        if(orderBo.getActivityList() == null || orderBo.getActivityList().size() == 0) return;
        List<ActivityBo> activityList = orderBo.getActivityList();
        List<GoodsBo> goodsList = orderBo.getGoodsList();

        BigDecimal discountPayPrice = BigDecimal.ZERO;
        for(ActivityBo activity : activityList) {
            for(GoodsBo goods : goodsList) {
                if(goods.getSkuId().compareTo(activity.getSkuId()) == 0) {
                    discountPayPrice = discountPayPrice.add(goods.getPrice().multiply(BigDecimal.valueOf(goods.getQuantity())).multiply(new BigDecimal(10).subtract(activity.getDiscount()).divide(new BigDecimal(10))));
                }
            }
        }
        logger.info("【折扣活动】折扣前价格：{}", orderBo.getPayPrice());
        orderBo.setPayPrice(orderBo.getPayPrice().subtract(discountPayPrice));
        orderBo.setDiscountPrice(orderBo.getDiscountPrice().add(discountPayPrice));

        logger.info("【折扣活动】折扣后价格：{}，抵扣：{}", orderBo.getPayPrice(), orderBo.getDiscountPrice());
    }
}
