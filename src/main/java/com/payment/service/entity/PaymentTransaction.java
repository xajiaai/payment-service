package com.payment.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 第三方支付交易实体。
 *
 * <p>保存 Apple / Google 返回的真实支付记录。</p>
 */
@Data
@TableName("payment_transaction")
public class PaymentTransaction {

    /** 主键ID */
    private Long id;

    /** 支付订单号 */
    private String paymentOrderNo;

    /** 支付渠道 */
    private String channel;

    /** 第三方交易ID */
    private String transactionId;

    /** Apple原始交易ID，用于订阅关联 */
    private String originalTransactionId;

    /** Google purchaseToken */
    private String purchaseToken;

    /** 交易状态 */
    private String transactionStatus;

    /** 第三方原始返回数据 */
    private String rawData;

    /** 创建时间 */
    private LocalDateTime createTime;
}
