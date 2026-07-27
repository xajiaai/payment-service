package com.payment.service.dto.request;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 创建支付订单请求。
 *
 * 流程：
 * 1. 用户选择商品
 * 2. 提交商品ID
 * 3. Payment Service 创建订单
 * 4. 返回 Apple/Google 支付参数
 */
@Data
public class CreateOrderRequest {

    /** 应用编码 */
    private String appCode;

    /** 业务用户ID */
    private String userId;

    /** 业务商品ID */
    private Long productId;

    /** 支付渠道，见 PaymentChannelEnum */
    private String channel;

    /**
     * 客户端金额，仅用于校验。
     * 最终金额以数据库商品配置为准。
     */
    private BigDecimal amount;

    /** 客户端请求幂等ID */
    private String requestId;
}
