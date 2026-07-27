package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentProductBenefit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品权益 Mapper。
 *
 * 查询商品购买后包含的权益描述。
 */
@Mapper
public interface PaymentProductBenefitMapper extends BaseMapper<PaymentProductBenefit> {

    /**
     * 根据商品ID查询权益。
     *
     * @param productId 商品ID
     * @return 商品权益列表
     */
    @Select("select * from payment_product_benefit where product_id=#{productId}")
    List<PaymentProductBenefit> selectByProductId(@Param("productId") Long productId);
}
