package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.AddressBo;
import com.japhone.demo.model.bo.FreightBo;

import java.util.List;

/**
 * created by japhone on 2020/9/1
 * 运费
 */
public interface FreightService {

    /**
     * 根据商品和收费地址获取运费
     * @param address
     * @param skuIdList
     * @return
     */
    FreightBo getFreight(AddressBo address, List<Long> skuIdList);

}
