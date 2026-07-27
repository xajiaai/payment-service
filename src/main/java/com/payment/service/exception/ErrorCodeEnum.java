package com.payment.service.exception;

/**
 * 支付系统统一错误码。
 *
 * 所有接口禁止直接返回字符串错误。
 * 统一通过枚举维护。
 */
public enum ErrorCodeEnum {

    SUCCESS(0, "成功"),

    PRODUCT_NOT_FOUND(10001, "商品不存在"),

    PRODUCT_DISABLED(10002, "商品已停用"),

    AMOUNT_ERROR(10003, "商品金额错误"),

    ORDER_NOT_FOUND(10004, "订单不存在"),

    ORDER_STATUS_ERROR(10005, "订单状态异常"),

    CHANNEL_NOT_SUPPORT(10006, "支付渠道不支持"),

    SYSTEM_ERROR(50000, "系统异常");

    private final int code;

    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
