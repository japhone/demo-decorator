package com.japhone.demo.order.service.pattern.factory.impl;

import com.japhone.demo.model.bo.FreightBo;
import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import com.japhone.demo.order.service.FreightService;
import com.japhone.demo.order.service.pattern.decorator.impl.FreightPayPriceDecorator;
import com.japhone.demo.order.service.pattern.decorator.impl.PayPriceComponent;
import com.japhone.demo.order.service.pattern.factory.IPayPriceComponentFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by japhone on 2020/9/15
 * 生产运费构件类
 */
@Component
public class FreightPayPriceComponent implements IPayPriceComponentFactory {

    @Resource
    private FreightService freightService;

    @Override
    public PayPriceComponent generatePayPriceComponent(SubmitOrderBo submitOrder, OrderBo order, PayPriceComponent component) {
        List<Long> skuIdList = submitOrder.getGoods().stream().map(e -> e.getSkuId()).collect(Collectors.toList());
        //如果有运费
        FreightBo freight = freightService.getFreight(submitOrder.getAddress(), skuIdList);
        order.setFreight(freight);
        return new FreightPayPriceDecorator(component);
    }
}
