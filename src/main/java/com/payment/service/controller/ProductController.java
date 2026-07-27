package com.payment.service.controller;

import com.payment.service.dto.request.ProductQueryRequest;
import com.payment.service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 商品查询接口。
 *
 * 用于业务系统获取当前 App 可购买商品。
 *
 * 注意：
 * 商品查询不会创建支付订单。
 */
@RestController
@RequestMapping("/api/payment/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 查询商品列表。
     *
     * @param request 查询条件
     * @return 商品列表
     */
    @GetMapping
    public Object list(ProductQueryRequest request) {
        return productService.queryProducts(request);
    }
}
