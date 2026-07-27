package com.payment.service.controller;

import com.payment.service.common.ApiResponse;
import com.payment.service.dto.request.VerifyOrderRequest;
import com.payment.service.service.VerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 支付验证接口。
 *
 * App支付完成后调用此接口，由服务端验证 Apple / Google 结果。
 */
@RestController
@RequestMapping("/api/payment/v1/verify")
@RequiredArgsConstructor
public class VerifyController {

    private final VerifyService verifyService;

    @PostMapping
    public ApiResponse<?> verify(@RequestBody VerifyOrderRequest request) {
        return ApiResponse.success(verifyService.verify(request));
    }
}
