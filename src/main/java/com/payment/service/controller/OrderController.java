package com.payment.service.controller;

import com.payment.service.dto.request.CreateOrderRequest;
import com.payment.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 支付订单接口。
 *
 * 用户点击购买后调用。
 */
@RestController
@RequestMapping("/api/payment/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * 创建支付订单。
     *
     * 流程：
     * 1. 根据 product_id 查询商品
     * 2. 查询 Apple / Google 商品映射
     * 3. 创建订单
     * 4. 返回第三方商品ID
     */
    @PostMapping
    public Object create(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}
