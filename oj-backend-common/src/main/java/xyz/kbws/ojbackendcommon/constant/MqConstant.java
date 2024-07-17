package xyz.kbws.ojbackendcommon.constant;

/**
 * @author kbws
 * @date 2024/2/14
 * @description: MQ 信息
 */
public interface MqConstant {
    /**
     * 普通交换机
     */
    String CODE_EXCHANGE_NAME = "code_exchange";
    String CODE_QUEUE = "code_queue";
    String CODE_ROUTING_KEY = "code_routingKey";
    String CODE_DIRECT_EXCHANGE = "direct";

    /**
     * 消息交换机
     */
    String NOTICE_QUEUE = "notice_queue";
    String NOTICE_EXCHANGE_NAME = "notice_exchange";
    String NOTICE_ROUTING_KEY = "notice_routingKey";
    String NOTICE_DIRECT_EXCHANGE = "direct";

    /**
     * 死信队列交换机
     */
    String CODE_DLX_EXCHANGE = "code-dlx-exchange";

    /**
     * 死信队列
     */
    String CODE_DLX_QUEUE = "code_dlx_queue";

    /**
     * 死信队列路由键
     */
    String CODE_DLX_ROUTING_KEY = "code_dlx_routingKey";
}
