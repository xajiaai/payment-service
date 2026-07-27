package com.payment.service.enums;

/**
 * 商品状态枚举。
 */
public enum ProductStatusEnum {

    /** 启用 */
    ENABLED(1, "启用"),

    /** 停用 */
    DISABLED(0, "停用");

    private final int code;
    private final String description;

    ProductStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() { return code; }
    public String getDescription() { return description; }
}
