package com.japhone.demo.order.service.impl;

import com.japhone.demo.model.bo.GoodsBo;
import com.japhone.demo.model.bo.OrderBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import com.japhone.demo.model.entity.Goods;
import com.japhone.demo.order.service.GoodsService;
import com.japhone.demo.order.service.OrderService;
import com.japhone.demo.order.service.PayPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * created by japhone on 2020-08-26
 */
@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private GoodsService goodsService;
    @Resource
    private PayPriceService payPriceService;

    @Override
    public void submit(SubmitOrderBo submitOrder) {
        OrderBo order = new OrderBo();
        /**生成订单号，这里取UUID**/
        order.setOrderNo(UUID.randomUUID().toString());
        List<GoodsBo> goodsList = submitOrder.getGoods();
        if(goodsList == null || goodsList.size() == 0) return;

        /**获取商品价格**/
        List<Long> skuIdList = goodsList.stream().map(e -> e.getSkuId()).collect(Collectors.toList());
        List<Goods> list = goodsService.queryBySkuIdList(skuIdList);

        for(GoodsBo goods : goodsList) {
            for(Goods goodsBo : list) {
                if(goodsBo.getSkuId().compareTo(goods.getSkuId()) == 0) {
                    goods.setPrice(goodsBo.getPrice());

                    break;
                }
            }
        }
        order.setGoodsList(goodsList);

        payPriceService.calculation(submitOrder, order);

        logger.info("装饰后：订单{}，总金额{}，实际支付金额{}", order.getOrderNo(), order.getTotalPrice(), order.getPayPrice());

    }
}
