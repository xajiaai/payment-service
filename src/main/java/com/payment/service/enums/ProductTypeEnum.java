package com.payment.service.enums;

/**
 * 商品类型枚举。
 */
public enum ProductTypeEnum {

    /**
     * 一次性购买商品。
     * 例如：积分包。
     */
    ONE_TIME("ONE_TIME", "一次性购买"),

    /**
     * 订阅商品。
     * 例如：月会员、年会员。
     */
    SUBSCRIPTION("SUBSCRIPTION", "订阅商品");

    private final String code;
    private final String description;

    ProductTypeEnum(String code, String description) {
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
