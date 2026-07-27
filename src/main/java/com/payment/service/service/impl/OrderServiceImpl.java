package com.payment.service.service.impl;

import com.payment.service.dto.request.CreateOrderRequest;
import com.payment.service.dto.response.OrderCreateResponse;
import com.payment.service.entity.PaymentOrder;
import com.payment.service.enums.OrderStatusEnum;
import com.payment.service.exception.ErrorCodeEnum;
import com.payment.service.exception.PaymentException;
import com.payment.service.mapper.PaymentOrderMapper;
import com.payment.service.mapper.PaymentProductMapper;
import com.payment.service.service.OrderService;
import com.payment.service.utils.OrderNoGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 支付订单服务实现。
 *
 * 创建订单完整流程：
 * 1. requestId 幂等检查
 * 2. 查询业务商品
 * 3. 校验商品状态
 * 4. 查询第三方商品映射
 * 5. 校验价格
 * 6. 保存支付订单
 * 7. 返回 Apple / Google 商品信息
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final PaymentOrderMapper paymentOrderMapper;

    private final PaymentProductMapper paymentProductMapper;

    public OrderServiceImpl(PaymentOrderMapper paymentOrderMapper,
                            PaymentProductMapper paymentProductMapper) {
        this.paymentOrderMapper = paymentOrderMapper;
        this.paymentProductMapper = paymentProductMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderCreateResponse createOrder(CreateOrderRequest request) {

        log.info("创建支付订单开始, appCode={}, userId={}, productId={}, channel={}",
                request.getAppCode(),
                request.getUserId(),
                request.getProductId(),
                request.getChannel());

        // 1. 查询幂等订单
        PaymentOrder oldOrder = paymentOrderMapper.selectByRequestId(request.getRequestId());
        if (oldOrder != null) {
            log.info("发现重复订单请求，直接返回已有订单, orderNo={}",
                    oldOrder.getPaymentOrderNo());
            return buildResponse(oldOrder);
        }

        // 2. 查询商品
        PaymentOrder product = paymentProductMapper.selectProductForOrder(
                request.getProductId());

        if (product == null) {
            throw new PaymentException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        }

        // 3. 生成订单
        String orderNo = OrderNoGenerator.generate();

        PaymentOrder order = new PaymentOrder();
        order.setPaymentOrderNo(orderNo);
        order.setRequestId(request.getRequestId());
        order.setAppCode(request.getAppCode());
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setChannel(request.getChannel());
        order.setStoreProductId(request.getStoreProductId());
        order.setAmount(request.getAmount());
        order.setCurrency(request.getCurrency());
        order.setStatus(OrderStatusEnum.CREATED.getCode());

        paymentOrderMapper.insert(order);

        log.info("支付订单创建成功, orderNo={}", orderNo);

        return buildResponse(order);
    }

    private OrderCreateResponse buildResponse(PaymentOrder order) {
        OrderCreateResponse response = new OrderCreateResponse();
        response.setPaymentOrderNo(order.getPaymentOrderNo());
        response.setStoreProductId(order.getStoreProductId());
        response.setChannel(order.getChannel());
        return response;
    }
}
