package com.payment.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 商品渠道映射实体。
 *
 * <p>负责业务商品与 Apple / Google 商品之间的映射。</p>
 */
@Data
@TableName("payment_product_mapping")
public class PaymentProductMapping {

    /** 主键ID */
    private Long id;

    /** 业务商品ID */
    private Long productId;

    /** 支付渠道：GOOGLE_PLAY / APPLE_IAP */
    private String channel;

    /** 第三方商品ID */
    private String storeProductId;

    /** 状态：1启用，0停用 */
    private Integer status;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;
}
