package com.japhone.demo.order.service.impl;

import com.japhone.demo.mapper.GoodsMapper;
import com.japhone.demo.model.entity.Goods;
import com.japhone.demo.order.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryBySkuIdList(List<Long> skuIdList) {
        return goodsMapper.queryBySkuIdList(skuIdList);
    }
}
