package com.japhone.demo.order.service.pattern.factory.impl;

import com.japhone.demo.model.bo.ActivityBo;
import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import com.japhone.demo.model.entity.Activity;
import com.japhone.demo.order.service.ActivityService;
import com.japhone.demo.order.service.pattern.decorator.impl.ActivityPayPriceDecorator;
import com.japhone.demo.order.service.pattern.decorator.impl.PayPriceComponent;
import com.japhone.demo.order.service.pattern.factory.IPayPriceComponentFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by japhone on 2020/9/15
 * 生产优惠券活动构件类
 */
@Component
public class ActivityPayPriceComponent implements IPayPriceComponentFactory {

    @Resource
    private ActivityService activityService;

    @Override
    public PayPriceComponent generatePayPriceComponent(SubmitOrderBo submitOrder, OrderBo order, PayPriceComponent component) {
        //如果有折扣活动
        List<Long> skuIdList = submitOrder.getGoods().stream().map(e -> e.getSkuId()).collect(Collectors.toList());
        List<Activity> activityList = activityService.queryActivity(skuIdList);
        if(activityList != null && activityList.size() > 0) {
            List<ActivityBo> activityBoList = activityList.stream().map(activity -> {
                ActivityBo activityBo = new ActivityBo();
                activityBo.setActivityId(activity.getId());
                activityBo.setSkuId(activity.getSkuId());
                activityBo.setDiscount(activity.getDiscount());

                return activityBo;
            }).collect(Collectors.toList());

            order.setActivityList(activityBoList);
            return new ActivityPayPriceDecorator(component);
        }
        return component;
    }
}
