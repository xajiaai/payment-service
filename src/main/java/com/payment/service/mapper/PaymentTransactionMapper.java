package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentTransaction;
import org.apache.ibatis.annotations.Mapper;

/**
 * 第三方支付交易 Mapper。
 */
@Mapper
public interface PaymentTransactionMapper extends BaseMapper<PaymentTransaction> {
}
