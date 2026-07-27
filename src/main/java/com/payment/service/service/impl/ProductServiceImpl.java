package com.payment.service.service.impl;

import com.payment.service.dto.request.ProductQueryRequest;
import com.payment.service.dto.response.ProductResponse;
import com.payment.service.exception.ErrorCodeEnum;
import com.payment.service.exception.PaymentException;
import com.payment.service.mapper.PaymentProductMapper;
import com.payment.service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品查询服务实现。
 *
 * 负责：
 * 1. 查询业务商品
 * 2. 获取渠道商品映射
 * 3. 返回客户端购买信息
 *
 * 注意：商品查询不会创建订单。
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final PaymentProductMapper paymentProductMapper;

    public ProductServiceImpl(PaymentProductMapper paymentProductMapper) {
        this.paymentProductMapper = paymentProductMapper;
    }

    @Override
    public List<ProductResponse> queryProducts(ProductQueryRequest request) {

        log.info("查询支付商品开始, appCode={}, channel={}",
                request.getAppCode(), request.getChannel());

        // 根据应用编码查询可售商品。
        // 后续通过 Mapper 联表查询：
        // payment_product
        // payment_product_mapping
        // payment_product_benefit
        List<ProductResponse> products = paymentProductMapper.queryProducts(
                request.getAppCode(), request.getChannel());

        if (products == null || products.isEmpty()) {
            log.warn("未找到可购买商品, appCode={}", request.getAppCode());
            throw new PaymentException(ErrorCodeEnum.PRODUCT_NOT_FOUND);
        }

        log.info("查询支付商品完成, count={}", products.size());
        return products;
    }
}
