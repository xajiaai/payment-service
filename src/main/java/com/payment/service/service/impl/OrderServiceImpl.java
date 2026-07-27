package com.payment.service.service.impl;

import com.payment.service.dto.request.CreateOrderRequest;
import com.payment.service.service.OrderService;
import com.payment.service.utils.OrderNoGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 支付订单服务实现。
 *
 * 核心流程：
 * 1. 校验业务商品
 * 2. 查询第三方商品映射
 * 3. 创建支付订单
 * 4. 返回Google/Apple支付参数
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Object createOrder(CreateOrderRequest request) {

        log.info("创建支付订单开始, appCode={}, userId={}, productId={}",
                request.getAppCode(),
                request.getUserId(),
                request.getProductId());

        // TODO 后续实现：
        // 1. 查询payment_product
        // 2. 校验商品状态
        // 3. 查询payment_product_mapping
        // 4. 校验金额
        // 5. requestId幂等查询
        // 6. 保存payment_order

        String orderNo = OrderNoGenerator.generate();

        log.info("生成支付订单号={}", orderNo);

        return orderNo;
    }
}
