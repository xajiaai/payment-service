package com.payment.service.enums;

/**
 * 支付订单状态枚举。
 */
public enum OrderStatusEnum {

    /** 已创建，等待支付 */
    CREATED("CREATED", "已创建"),

    /** 支付处理中 */
    PAYING("PAYING", "支付中"),

    /** 支付成功 */
    SUCCESS("SUCCESS", "支付成功"),

    /** 支付失败 */
    FAILED("FAILED", "支付失败"),

    /** 已退款 */
    REFUND("REFUND", "退款"),

    /** 已关闭 */
    CLOSED("CLOSED", "已关闭");

    private final String code;
    private final String description;

    OrderStatusEnum(String code, String description) {
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
