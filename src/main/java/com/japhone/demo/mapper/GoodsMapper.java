package com.japhone.demo.mapper;

import com.japhone.demo.model.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
public interface GoodsMapper {
    List<Goods> queryBySkuIdList(@Param("skuIdList") List<Long> skuIdList);
}
