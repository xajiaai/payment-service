package com.payment.service.exception;

import lombok.Getter;

/**
 * 支付服务业务异常。
 *
 * 所有可预期业务错误统一使用该异常抛出，
 * 由全局异常处理器转换为标准接口返回。
 */
@Getter
public class PaymentException extends RuntimeException {

    private final ErrorCodeEnum errorCode;

    public PaymentException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
