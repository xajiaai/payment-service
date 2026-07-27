package com.payment.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.payment.service.entity.PaymentOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 支付订单 Mapper。
 *
 * 支持订单创建、查询、状态更新。
 */
@Mapper
public interface PaymentOrderMapper extends BaseMapper<PaymentOrder> {

    /**
     * 根据请求幂等号查询订单。
     *
     * 防止客户端网络异常导致重复创建订单。
     *
     * @param requestId 请求唯一ID
     * @return 已存在订单
     */
    @Select("select * from payment_order where request_id=#{requestId} limit 1")
    PaymentOrder selectByRequestId(@Param("requestId") String requestId);
}
