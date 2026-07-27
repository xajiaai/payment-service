package com.payment.service.service.impl;

import com.payment.service.dto.request.ProductQueryRequest;
import com.payment.service.dto.response.ProductResponse;
import com.payment.service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 商品查询服务实现。
 *
 * 负责：
 * 1. 查询业务商品
 * 2. 查询Apple/Google商品映射
 * 3. 返回App可购买商品列表
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductResponse> queryProducts(ProductQueryRequest request) {
        log.info("查询支付商品开始, appCode={}, channel={}",
                request.getAppCode(), request.getChannel());

        // TODO 后续接入Mapper查询：
        // payment_product
        // payment_product_mapping
        // payment_product_benefit

        return Collections.emptyList();
    }
}
