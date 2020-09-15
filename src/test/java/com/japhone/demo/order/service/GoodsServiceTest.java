package com.japhone.demo.order.service;

import com.japhone.demo.model.entity.Goods;
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
public class GoodsServiceTest {

    Logger logger = LoggerFactory.getLogger(GoodsServiceTest.class);

    @Resource
    private GoodsService goodsService;

    @Test
    public void queryBySkuIdList(){
        List<Long> skuIdList = new ArrayList<>();
        skuIdList.add(1001l);
        skuIdList.add(1003l);
        skuIdList.add(1004l);
        List<Goods> goodsList = goodsService.queryBySkuIdList(skuIdList);

        logger.info("result : {}", goodsList);
    }

}
