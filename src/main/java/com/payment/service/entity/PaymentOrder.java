package com.payment.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付订单实体。
 *
 * <p>该对象对应 payment_order 表。</p>
 *
 * <p>订单表示用户一次明确的购买行为，
 * 创建前必须已经确定 product_id。</p>
 */
@Data
@TableName("payment_order")
public class PaymentOrder {

    /** 主键ID */
    private Long id;

    /** 支付订单号，全局唯一 */
    private String paymentOrderNo;

    /** 创建订单请求幂等ID */
    private String requestId;

    /** 应用编码 */
    private String appCode;

    /** 业务用户ID */
    private String userId;

    /** 业务商品ID */
    private Long productId;

    /** 支付渠道，使用 PaymentChannelEnum 定义 */
    private String channel;

    /** 创建订单时保存的第三方商品ID快照 */
    private String storeProductId;

    /** 支付金额 */
    private BigDecimal amount;

    /** 支付币种 */
    private String currency;

    /** 订单状态，使用 OrderStatusEnum 定义 */
    private String status;

    /** 通知业务系统状态，使用 NotifyStatusEnum 定义 */
    private String notifyStatus;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;
}
