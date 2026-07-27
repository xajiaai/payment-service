package com.payment.service.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品返回对象。
 *
 * 提供给 App 展示购买页面使用。
 */
@Data
public class ProductResponse {

    /** 商品ID */
    private Long productId;

    /** 商品编码 */
    private String productCode;

    /** 商品名称 */
    private String productName;

    /** 商品类型 */
    private String productType;

    /** 商品价格 */
    private BigDecimal amount;

    /** 币种 */
    private String currency;

    /** Apple/Google商品ID */
    private String storeProductId;

    /** 商品权益 */
    private List<BenefitResponse> benefits;
}
