package com.japhone.demo.order.service;

import com.japhone.demo.model.bo.ActivityBo;
import com.japhone.demo.model.entity.Activity;

import java.util.List;

/**
 * created by japhone on 2020/9/1
 * 活动
 */
public interface ActivityService {

    /**
     * 获取商品的活动信息
     * @param skuIds
     * @return
     */
    List<Activity> queryActivity(List<Long> skuIds);

}
