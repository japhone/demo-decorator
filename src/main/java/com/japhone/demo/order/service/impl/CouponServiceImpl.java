package com.japhone.demo.order.service.impl;

import com.japhone.demo.mapper.CouponMapper;
import com.japhone.demo.model.entity.Coupon;
import com.japhone.demo.order.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public Coupon getByCode(String code) {
        List<Coupon> list = couponMapper.getByCode(code);
        if(list == null || list.size() == 0) return null;
        return list.get(0);
    }
}
