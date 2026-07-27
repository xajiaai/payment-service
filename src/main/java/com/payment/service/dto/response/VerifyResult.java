package com.payment.service.dto.response;

import lombok.Data;

/**
 * 第三方支付验证结果。
 *
 * Google Play 和 Apple IAP 使用统一结构返回。
 */
@Data
public class VerifyResult {

    /**
     * 是否验证成功。
     */
    private boolean success;

    /**
     * 第三方交易ID。
     */
    private String transactionId;

    /**
     * 原始订阅交易ID，主要用于Apple订阅。
     */
    private String originalTransactionId;

    /**
     * 原始渠道返回数据。
     */
    private String rawData;
}
