package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.AddressBo;
import com.japhone.demo.model.bo.CouponBo;
import com.japhone.demo.model.bo.GoodsBo;
import com.japhone.demo.model.bo.SubmitOrderBo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
@SpringBootTest
public class OrderServiceTest {

    private Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);

    @Resource
    private OrderService orderService;

    @Test
    public void submit(){
        SubmitOrderBo submitOrder = new SubmitOrderBo();

        /**收货地址**/
        AddressBo address = new AddressBo();
        address.setCountryCode("110105");

        /**购买的商品**/
        List<GoodsBo> goodsList = new ArrayList<>();
        GoodsBo goodsBo = new GoodsBo();
        goodsBo.setSkuId(1001l);
        goodsBo.setQuantity(10);
        goodsList.add(goodsBo);

        goodsBo = new GoodsBo();
        goodsBo.setSkuId(1002l);
        goodsBo.setQuantity(2);
        goodsList.add(goodsBo);

        /**使用优惠券**/
        CouponBo coupon = new CouponBo();
        coupon.setCode("20200001");

        submitOrder.setAddress(address);
        submitOrder.setGoods(goodsList);
        submitOrder.setCoupon(coupon);

        /**提交订单**/
        orderService.submit(submitOrder);
    }
}
