package com.payment.service.mapper;

import com.payment.service.entity.PaymentProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支付商品查询Mapper。
 *
 * 用于查询App可购买商品。
 */
@Mapper
public interface PaymentProductQueryMapper {

    /**
     * 根据应用编码查询启用商品。
     *
     * @param appCode 应用编码
     * @return 商品列表
     */
    List<PaymentProduct> selectEnabledProducts(@Param("appCode") String appCode);
}
