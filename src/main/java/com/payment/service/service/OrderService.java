package com.payment.service.service;

import com.payment.service.dto.request.CreateOrderRequest;

/**
 * 支付订单服务。
 *
 * 负责：
 * 1. 校验商品
 * 2. 获取 Apple/Google 商品映射
 * 3. 创建支付订单
 */
public interface OrderService {

    /**
     * 创建支付订单。
     *
     * @param request 创建订单请求
     * @return 支付参数
     */
    Object createOrder(CreateOrderRequest request);
}
