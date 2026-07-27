package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付订单 Mapper。
 *
 * 支持订单创建、查询、状态更新。
 */
@Mapper
public interface PaymentOrderMapper extends BaseMapper<PaymentOrder> {
}
