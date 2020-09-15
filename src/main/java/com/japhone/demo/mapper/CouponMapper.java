package com.japhone.demo.mapper;

import com.japhone.demo.model.entity.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
public interface CouponMapper {
    List<Coupon> getByCode(@Param("code") String code);
}
