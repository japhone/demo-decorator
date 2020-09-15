package com.japhone.demo.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * created by japhone on 2020/9/1
 * 运费
 */
public class FreightBo implements Serializable {

    /**
     * 运费模板ID
     */
    private Long freightTemplateId;

    /**
     * 商品sku
     */
    private Long skuId;

    /**
     * 运费
     */
    private BigDecimal freight;

    public Long getFreightTemplateId() {
        return freightTemplateId;
    }

    public void setFreightTemplateId(Long freightTemplateId) {
        this.freightTemplateId = freightTemplateId;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    @Override
    public String toString() {
        return "FreightBo{" +
                "freightTemplateId=" + freightTemplateId +
                ", skuId=" + skuId +
                ", freight=" + freight +
                '}';
    }
}
