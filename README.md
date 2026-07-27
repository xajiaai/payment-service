# Payment Service

多 App 统一支付服务。

## 目标

支持：

- Google Play Billing
- Apple In-App Purchase
- 多 App 接入
- 商品映射
- 支付订单
- 支付验证
- 支付成功通知及失败重试

## 设计原则

1. 商品先查询，用户选择后创建订单。
2. Payment Service 负责支付事实，不负责用户权益。
3. 业务系统负责 VIP、积分等权益发放。
4. 支付成功通知业务系统必须支持重试和幂等。
5. 所有业务状态使用 Java 枚举定义。
6. MySQL 不使用外键，仅使用索引约束。

## 技术栈

- Java 17
- Spring Boot 3
- MyBatis Plus
- MySQL 5.7
- Log4j2
