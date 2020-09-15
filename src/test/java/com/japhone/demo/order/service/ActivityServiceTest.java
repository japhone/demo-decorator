package com.japhone.demo.order.service;

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
public class ActivityServiceTest {

    private Logger logger = LoggerFactory.getLogger(ActivityServiceTest.class);

    @Resource
    private ActivityService activityService;

    @Test
    public void queryActivity(){
        List<Long> skuIds = new ArrayList<>();
        skuIds.add(1001l);
        skuIds.add(1002l);
        logger.info("result: {}", activityService.queryActivity(skuIds));
    }

}
