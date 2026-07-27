package com.payment.service.service.impl;

import com.payment.service.dto.request.CreateOrderRequest;
import com.payment.service.dto.response.OrderCreateResponse;
import com.payment.service.enums.OrderStatusEnum;
import com.payment.service.service.OrderService;
import com.payment.service.utils.OrderNoGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 支付订单服务实现。
 *
 * 订单创建流程：
 *
 * 1. 接收用户选择的 productId
 * 2. 查询业务商品
 * 3. 校验商品状态
 * 4. 查询 Google / Apple 商品映射
 * 5. 校验客户端金额
 * 6. 根据 requestId 保证幂等
 * 7. 创建支付订单
 * 8. 返回第三方商品ID给客户端调用支付SDK
 *
 * 注意：
 * 创建订单之前，商品必须已经确定。
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Object createOrder(CreateOrderRequest request) {

        log.info("创建支付订单开始, appCode={}, userId={}, productId={}, channel={}",
                request.getAppCode(),
                request.getUserId(),
                request.getProductId(),
                request.getChannel());

        /**
         * TODO 后续接入 Mapper：
         *
         * 1. 查询 payment_product
         *
         * 2. 校验商品状态
         *    status=1 才允许购买
         *
         * 3. 查询 payment_product_mapping
         *    获取 Google productId 或 Apple productId
         *
         * 4. 校验金额
         *    请求金额不能覆盖数据库商品价格
         *
         * 5. requestId 幂等查询
         *    已存在订单直接返回
         *
         * 6. 保存 payment_order
         */

        String orderNo = OrderNoGenerator.generate();

        log.info("生成支付订单号={}, 初始状态={}",
                orderNo,
                OrderStatusEnum.CREATED.getCode());

        // 当前返回结构占位，Mapper接入后替换为真实数据。
        return new OrderCreateResponse();
    }
}
