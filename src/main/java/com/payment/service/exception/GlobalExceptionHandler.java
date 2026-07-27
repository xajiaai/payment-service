package com.payment.service.exception;

import com.payment.service.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器。
 *
 * 统一处理支付服务业务异常和系统异常。
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常。
     */
    @ExceptionHandler(PaymentException.class)
    public ApiResponse<Void> handlePaymentException(PaymentException e) {
        log.warn("支付业务异常:{}", e.getMessage());
        return ApiResponse.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理未知异常。
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleException(Exception e) {
        log.error("系统异常", e);
        return ApiResponse.fail(
                ErrorCodeEnum.SYSTEM_ERROR.getCode(),
                ErrorCodeEnum.SYSTEM_ERROR.getMessage()
        );
    }
}
