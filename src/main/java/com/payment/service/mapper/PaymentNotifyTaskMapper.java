package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentNotifyTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付结果通知任务 Mapper。
 *
 * 用于支付成功后通知业务系统，以及失败重试。
 */
@Mapper
public interface PaymentNotifyTaskMapper extends BaseMapper<PaymentNotifyTask> {
}
