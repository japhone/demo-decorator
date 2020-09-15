package com.japhone.demo.order.service.impl;

import com.japhone.demo.mapper.FreightMapper;
import com.japhone.demo.model.bo.AddressBo;
import com.japhone.demo.model.bo.FreightBo;
import com.japhone.demo.model.entity.Freight;
import com.japhone.demo.order.service.FreightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * created by japhone on 2020/9/14
 */
@Service
public class FreightServiceImpl implements FreightService {

    @Resource
    private FreightMapper freightMapper;

    @Override
    public FreightBo getFreight(AddressBo address, List<Long> skuIdList) {
        if(address == null || skuIdList == null || skuIdList.size() == 0) return null;
        List<Freight> list = freightMapper.getFreight(address, skuIdList);

        FreightBo freightBo = new FreightBo();
        freightBo.setFreightTemplateId(0l);
        freightBo.setFreight(BigDecimal.ZERO);
        if(list == null || list.size() == 0) {
            return freightBo;
        }

        /**如果有多个运费，则取运费最大的**/
        Freight freight = list.stream().max((e1, e2) -> e1.getFreight().compareTo(e2.getFreight())).get();
        freightBo.setFreightTemplateId(freight.getFreightTemplateId());
        freightBo.setFreight(freight.getFreight());
        freightBo.setSkuId(freight.getSkuId());

        return freightBo;
    }
}
