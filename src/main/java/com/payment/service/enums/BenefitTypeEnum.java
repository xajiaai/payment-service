package com.payment.service.enums;

/**
 * 商品权益类型枚举。
 *
 * 注意：这里只描述购买商品包含的权益。
 * 不代表用户实际拥有的权益。
 */
public enum BenefitTypeEnum {

    /** 时间权益，例如VIP有效天数 */
    TIME("TIME", "时间权益"),

    /** 积分权益 */
    POINT("POINT", "积分权益");

    private final String code;
    private final String description;

    BenefitTypeEnum(String code, String description) {
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
