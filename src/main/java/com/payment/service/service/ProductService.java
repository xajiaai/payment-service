package com.payment.service.service;

import com.payment.service.dto.request.ProductQueryRequest;
import com.payment.service.dto.response.ProductResponse;

import java.util.List;

/**
 * 商品服务。
 *
 * 负责：
 * 1. 查询业务商品
 * 2. 查询渠道商品映射
 * 3. 组装 App 使用的购买商品信息
 */
public interface ProductService {

    /**
     * 查询可购买商品列表。
     *
     * @param request 查询条件
     * @return 商品列表
     */
    List<ProductResponse> queryProducts(ProductQueryRequest request);
}
