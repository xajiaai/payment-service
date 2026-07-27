package com.payment.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 支付结果通知任务。
 *
 * <p>用于支付成功后通知业务系统。</p>
 *
 * <p>如果业务系统失败，通过该任务进行自动重试。</p>
 */
@Data
@TableName("payment_notify_task")
public class PaymentNotifyTask {

    /** 主键ID */
    private Long id;

    /** 支付订单号 */
    private String paymentOrderNo;

    /** 通知类型 */
    private String notifyType;

    /** 业务系统通知地址 */
    private String targetUrl;

    /** 通知请求内容 */
    private String requestBody;

    /** 通知状态 */
    private String status;

    /** 重试次数 */
    private Integer retryCount;

    /** 下次重试时间 */
    private LocalDateTime nextRetryTime;

    /** 最近错误信息 */
    private String lastError;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;
}
