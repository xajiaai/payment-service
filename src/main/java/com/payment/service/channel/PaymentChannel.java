package com.payment.service.channel;

import com.payment.service.dto.response.VerifyResult;

/**
 * 支付渠道统一接口。
 *
 * Apple IAP 和 Google Play Billing 均通过该接口接入。
 */
public interface PaymentChannel {

    /**
     * 验证第三方支付结果。
     *
     * @param transactionId 第三方交易ID
     * @param token Google purchaseToken 或 Apple transaction信息
     * @return 验证结果
     */
    VerifyResult verify(String transactionId, String token);
}
