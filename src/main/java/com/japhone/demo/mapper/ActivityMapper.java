package com.japhone.demo.mapper;

import com.japhone.demo.model.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
public interface ActivityMapper {
    List<Activity> queryActivity(@Param("skuIds") List<Long> skuIds);
}
