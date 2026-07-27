-- =====================================================
-- Multi App Payment Service 数据库设计
-- MySQL 5.7
-- 不使用外键，仅使用索引保证查询性能
-- =====================================================

CREATE TABLE payment_app (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    app_code VARCHAR(64) NOT NULL COMMENT '应用编码，唯一标识一个接入应用，例如 beddy_stories',
    app_name VARCHAR(128) NOT NULL COMMENT '应用名称',
    status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1=启用，0=停用',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(id),
    UNIQUE KEY uk_app_code(app_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付接入应用配置表';

CREATE TABLE payment_product (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品ID',
    app_code VARCHAR(64) NOT NULL COMMENT '应用编码',
    product_code VARCHAR(64) NOT NULL COMMENT '业务商品编码，例如 year_vip',
    product_name VARCHAR(128) NOT NULL COMMENT '商品名称',
    product_type VARCHAR(32) NOT NULL COMMENT '商品类型：ONE_TIME=一次性商品，SUBSCRIPTION=订阅商品',
    amount DECIMAL(10,2) NOT NULL COMMENT '商品价格',
    currency VARCHAR(16) NOT NULL COMMENT '货币类型，例如 USD',
    status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1=启用，0=停用',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(id),
    UNIQUE KEY uk_product(app_code,product_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付业务商品定义表';

CREATE TABLE payment_product_mapping (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    product_id BIGINT NOT NULL COMMENT '业务商品ID，对应payment_product.id',
    channel VARCHAR(32) NOT NULL COMMENT '支付渠道：GOOGLE_PLAY=Google Play，APPLE_IAP=Apple IAP',
    store_product_id VARCHAR(128) NOT NULL COMMENT '第三方商品ID，Google productId 或 Apple productId',
    status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1=启用，0=停用',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(id),
    UNIQUE KEY uk_channel_product(channel,store_product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务商品与Apple/Google商品映射表';

CREATE TABLE payment_product_benefit (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    product_id BIGINT NOT NULL COMMENT '业务商品ID',
    benefit_type VARCHAR(32) NOT NULL COMMENT '权益类型：TIME=时间权益，POINT=积分权益',
    benefit_value INT NOT NULL COMMENT '权益数量',
    benefit_unit VARCHAR(32) NOT NULL COMMENT '权益单位：DAY=天，POINT=积分',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品购买后产生的权益描述表';

CREATE TABLE payment_order (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    payment_order_no VARCHAR(64) NOT NULL COMMENT '支付订单号，全局唯一',
    request_id VARCHAR(64) NOT NULL COMMENT '请求幂等ID',
    app_code VARCHAR(64) NOT NULL COMMENT '应用编码',
    user_id VARCHAR(64) NOT NULL COMMENT '业务用户ID',
    product_id BIGINT NOT NULL COMMENT '业务商品ID',
    channel VARCHAR(32) NOT NULL COMMENT '支付渠道：GOOGLE_PLAY或APPLE_IAP',
    store_product_id VARCHAR(128) NOT NULL COMMENT '创建订单时使用的第三方商品ID快照',
    amount DECIMAL(10,2) NOT NULL COMMENT '支付金额',
    currency VARCHAR(16) NOT NULL COMMENT '支付币种',
    status VARCHAR(32) NOT NULL COMMENT '订单状态：CREATED创建，PAYING支付中，SUCCESS成功，FAILED失败，REFUND退款，CLOSED关闭',
    notify_status VARCHAR(32) NOT NULL COMMENT '通知状态：PENDING待通知，SUCCESS成功，FAILED失败',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(id),
    UNIQUE KEY uk_order_no(payment_order_no),
    UNIQUE KEY uk_request_id(request_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付订单表';

CREATE TABLE payment_transaction (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    payment_order_no VARCHAR(64) NOT NULL COMMENT '支付订单号',
    channel VARCHAR(32) NOT NULL COMMENT '支付渠道',
    transaction_id VARCHAR(256) NOT NULL COMMENT '第三方交易ID',
    original_transaction_id VARCHAR(256) DEFAULT NULL COMMENT 'Apple订阅原始交易ID',
    purchase_token VARCHAR(512) DEFAULT NULL COMMENT 'Google purchaseToken',
    transaction_status VARCHAR(32) NOT NULL COMMENT '交易状态：SUCCESS成功，REFUND退款，REVOKED撤销',
    raw_data TEXT COMMENT '第三方返回原始数据',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    PRIMARY KEY(id),
    UNIQUE KEY uk_transaction(channel,transaction_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='第三方支付交易记录表';

CREATE TABLE payment_notify_task (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    payment_order_no VARCHAR(64) NOT NULL COMMENT '支付订单号',
    notify_type VARCHAR(32) NOT NULL COMMENT '通知类型：PAYMENT_SUCCESS支付成功，REFUND退款',
    target_url VARCHAR(512) NOT NULL COMMENT '业务系统通知地址',
    request_body TEXT COMMENT '通知请求内容',
    status VARCHAR(32) NOT NULL COMMENT '通知状态：PENDING待处理，SUCCESS成功，FAILED失败',
    retry_count INT NOT NULL DEFAULT 0 COMMENT '重试次数',
    next_retry_time DATETIME COMMENT '下次重试时间',
    last_error VARCHAR(512) COMMENT '最后一次错误信息',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY(id),
    UNIQUE KEY uk_order_notify(payment_order_no,notify_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付结果通知重试任务表';
