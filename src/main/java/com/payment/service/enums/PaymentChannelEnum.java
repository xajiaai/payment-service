package com.payment.service.enums;

/**
 * 支付渠道枚举。
 *
 * 用于统一管理第三方支付平台类型。
 * 禁止业务代码直接硬编码字符串。
 */
public enum PaymentChannelEnum {

    /**
     * Google Play Billing支付。
     */
    GOOGLE_PLAY("GOOGLE_PLAY", "Google Play Billing"),

    /**
     * Apple In-App Purchase支付。
     */
    APPLE_IAP("APPLE_IAP", "Apple In App Purchase");

    private final String code;
    private final String description;

    PaymentChannelEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
