package com.payment.service.enums;

/**
 * 业务通知任务状态枚举。
 */
public enum NotifyStatusEnum {

    /** 等待通知 */
    PENDING("PENDING", "待通知"),

    /** 通知成功 */
    SUCCESS("SUCCESS", "通知成功"),

    /** 通知失败，等待重试 */
    FAILED("FAILED", "通知失败");

    private final String code;
    private final String description;

    NotifyStatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }
}
