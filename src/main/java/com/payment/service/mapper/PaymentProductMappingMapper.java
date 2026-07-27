package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentProductMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 第三方商品映射 Mapper。
 *
 * 管理业务商品与 Apple/Google 商品关系。
 */
@Mapper
public interface PaymentProductMappingMapper extends BaseMapper<PaymentProductMapping> {

    /**
     * 根据业务商品和支付渠道查询第三方商品ID。
     *
     * @param productId 业务商品ID
     * @param channel 支付渠道
     * @return 第三方商品映射
     */
    @Select("select * from payment_product_mapping where product_id=#{productId} and channel=#{channel} and status=1 limit 1")
    PaymentProductMapping selectByProductAndChannel(
            @Param("productId") Long productId,
            @Param("channel") String channel
    );
}
