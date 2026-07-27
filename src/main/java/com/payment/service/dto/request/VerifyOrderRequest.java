package com.payment.service.dto.request;

import lombok.Data;

/**
 * 支付验证请求。
 *
 * Google 使用 purchaseToken。
 * Apple 使用 transactionId。
 */
@Data
public class VerifyOrderRequest {

    /** 支付订单号 */
    private String paymentOrderNo;

    /** 支付渠道 */
    private String channel;

    /** Google purchaseToken */
    private String purchaseToken;

    /** Apple transactionId */
    private String transactionId;
}
