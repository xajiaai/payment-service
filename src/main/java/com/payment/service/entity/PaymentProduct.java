package com.payment.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付商品实体。
 *
 * <p>定义 App 中可购买的业务商品。</p>
 *
 * <p>例如：月会员、年会员、积分包。</p>
 */
@Data
@TableName("payment_product")
public class PaymentProduct {

    /** 商品ID */
    private Long id;

    /** 应用编码 */
    private String appCode;

    /** 业务商品编码 */
    private String productCode;

    /** 商品名称 */
    private String productName;

    /** 商品类型：ONE_TIME / SUBSCRIPTION */
    private String productType;

    /** 商品价格 */
    private BigDecimal amount;

    /** 币种 */
    private String currency;

    /** 商品状态：1启用，0停用 */
    private Integer status;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;
}
