package com.japhone.demo.mapper;

import com.japhone.demo.model.bo.AddressBo;
import com.japhone.demo.model.entity.Freight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
public interface FreightMapper {
    List<Freight> getFreight(@Param("address") AddressBo address, @Param("skuIdList") List<Long> skuIdList);
}
