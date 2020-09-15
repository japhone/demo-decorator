package com.japhone.demo.common.enums;

/**
 * created by japhone on 2020/9/1
 * 优惠券类型
 */
public enum CouponTypeEnum {

    /**
     * 满减
     */
    FULL_REDUCTION(1, "满减"),
    /**
     * 直降
     */
    DEDUCTION(2, "直降");

    private Integer code;
    private String desc;

    CouponTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
