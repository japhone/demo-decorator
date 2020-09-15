package com.japhone.demo.order.service.impl;

import com.japhone.demo.mapper.ActivityMapper;
import com.japhone.demo.model.entity.Activity;
import com.japhone.demo.order.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by japhone on 2020/9/14
 * 活动
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> queryActivity(List<Long> skuIds) {
        return activityMapper.queryActivity(skuIds);
    }
}
