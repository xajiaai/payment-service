package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 支付商品 Mapper。
 *
 * 负责 payment_product 表的数据访问。
 */
@Mapper
public interface PaymentProductMapper extends BaseMapper<PaymentProduct> {

    /**
     * 根据商品ID查询商品。
     *
     * @param productId 商品ID
     * @return 商品信息
     */
    PaymentProduct selectByProductId(@Param("productId") Long productId);
}
