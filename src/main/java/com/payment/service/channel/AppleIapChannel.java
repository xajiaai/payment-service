package com.payment.service.channel;

import com.payment.service.dto.response.VerifyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Apple In-App Purchase渠道实现。
 *
 * 后续接入Apple App Store Server API。
 */
@Slf4j
@Component
public class AppleIapChannel implements PaymentChannel {

    @Override
    public VerifyResult verify(String transactionId, String token) {
        log.info("Apple IAP支付验证开始, transactionId={}", transactionId);

        // TODO:
        // 1. 调用Apple Server API
        // 2. 验证transactionId
        // 3. 获取交易状态
        // 4. 返回统一VerifyResult

        return new VerifyResult();
    }
}
