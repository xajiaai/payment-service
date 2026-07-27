package com.payment.service.dto.response;

import lombok.Data;

/**
 * 创建支付订单返回对象。
 *
 * 返回给业务系统的信息用于后续调用 Apple / Google 支付 SDK。
 */
@Data
public class OrderCreateResponse {

    /**
     * 支付订单号。
     *
     * 该订单号贯穿整个支付生命周期。
     */
    private String paymentOrderNo;

    /**
     * 支付渠道。
     *
     * 枚举：
     * GOOGLE_PLAY
     * APPLE_IAP
     */
    private String channel;

    /**
     * 第三方商品ID。
     *
     * Google：productId
     * Apple：productId
     */
    private String storeProductId;
}
