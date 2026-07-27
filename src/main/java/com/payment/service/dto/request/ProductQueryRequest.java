package com.payment.service.dto.request;

import lombok.Data;

/**
 * 商品查询请求参数。
 *
 * 用于 App 展示可购买商品。
 *
 * 注意：
 * 商品查询阶段不会创建支付订单。
 */
@Data
public class ProductQueryRequest {

    /**
     * 应用编码，例如 beddy_stories。
     */
    private String appCode;

    /**
     * 支付渠道。
     *
     * 枚举：
     * PaymentChannelEnum
     */
    private String channel;
}
