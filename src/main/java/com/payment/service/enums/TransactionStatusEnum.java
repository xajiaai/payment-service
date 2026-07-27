package com.payment.service.enums;

/**
 * 第三方交易状态枚举。
 */
public enum TransactionStatusEnum {

    /** 支付成功 */
    SUCCESS("SUCCESS", "支付成功"),

    /** 已退款 */
    REFUND("REFUND", "已退款"),

    /** 已撤销 */
    REVOKED("REVOKED", "已撤销");

    private final String code;
    private final String description;

    TransactionStatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }
}
