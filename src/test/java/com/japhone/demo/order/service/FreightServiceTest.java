package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.AddressBo;
import com.japhone.demo.model.bo.FreightBo;
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
public class FreightServiceTest {

    private Logger logger = LoggerFactory.getLogger(FreightServiceTest.class);

    @Resource
    private FreightService freightService;

    @Test
    public void getFreight(){
        AddressBo address = new AddressBo();
        address.setCountryCode("110105");   //110105    370683

        List<Long> skuIdList = new ArrayList<>();
        skuIdList.add(1001l);
        skuIdList.add(1002l);
        FreightBo freight = freightService.getFreight(address, skuIdList);

        logger.info("result: {}", freight);
    }

}
