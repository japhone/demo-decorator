package com.japhone.demo.order.service;

import com.japhone.demo.model.entity.Coupon;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * created by japhone on 2020/9/14
 */
@SpringBootTest
public class CouponServiceTest {

    private Logger logger = LoggerFactory.getLogger(CouponServiceTest.class);

    @Resource
    private CouponService couponService;

    @Test
    public void getByCode(){
        Coupon coupon = couponService.getByCode("20200002");
        logger.info("result: {}", coupon);
    }

}
