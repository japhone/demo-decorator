package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.GoodsBo;
import com.japhone.demo.model.entity.Goods;

import java.util.List;

/**
 * created by japhone on 2020/9/1
 */
public interface GoodsService {

    /**
     * 根据skuId获取商品信息
     * @param skuIdList
     * @return
     */
    List<Goods> queryBySkuIdList(List<Long> skuIdList);

}
