package com.payment.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Payment Service启动入口。
 *
 * <p>系统定位：</p>
 * <ul>
 *     <li>统一管理多个App支付流程</li>
 *     <li>支持Google Play Billing</li>
 *     <li>支持Apple In-App Purchase</li>
 *     <li>负责支付事实确认，不负责业务权益管理</li>
 * </ul>
 */
@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
