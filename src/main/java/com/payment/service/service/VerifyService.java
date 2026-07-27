package com.payment.service.service;

import com.payment.service.dto.request.VerifyOrderRequest;
import com.payment.service.dto.response.VerifyResult;

/**
 * 支付验证服务。
 *
 * 负责调用 Apple / Google 渠道验证支付结果。
 */
public interface VerifyService {

    /**
     * 验证支付结果。
     *
     * @param request 验证请求
     * @return 第三方支付验证结果
     */
    VerifyResult verify(VerifyOrderRequest request);
}
