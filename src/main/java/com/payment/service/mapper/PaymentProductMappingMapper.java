package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentProductMapping;
import org.apache.ibatis.annotations.Mapper;

/**
 * 第三方商品映射 Mapper。
 *
 * 管理业务商品与 Apple/Google 商品关系。
 */
@Mapper
public interface PaymentProductMappingMapper extends BaseMapper<PaymentProductMapping> {
}
