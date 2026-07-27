package com.payment.service.channel;

import com.payment.service.dto.response.VerifyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Google Play Billing支付渠道实现。
 *
 * 后续接入 Google Play Developer API 完成 purchaseToken 验证。
 */
@Slf4j
@Component
public class GooglePlayChannel implements PaymentChannel {

    @Override
    public VerifyResult verify(String transactionId, String token) {
        log.info("Google Play支付验证开始, transactionId={}", transactionId);

        // TODO:
        // 1. 调用Google Play Developer API
        // 2. 验证purchaseToken
        // 3. 获取购买状态
        // 4. 返回统一VerifyResult

        return new VerifyResult();
    }
}
