package com.payment.service.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 支付订单号生成工具。
 *
 * 订单号要求：
 * 1. 全局唯一
 * 2. 便于人工查询
 * 3. 不依赖数据库自增ID
 */
public final class OrderNoGenerator {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private OrderNoGenerator() {
    }

    /**
     * 生成支付订单号。
     *
     * 格式：
     * PO + 时间 + 随机数字
     *
     * 示例：
     * PO20260727111900123
     */
    public static String generate() {
        String time = LocalDateTime.now().format(FORMATTER);
        int random = ThreadLocalRandom.current().nextInt(100, 999);
        return "PO" + time + random;
    }
}
