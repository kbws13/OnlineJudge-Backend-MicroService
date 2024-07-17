package xyz.kbws.ojbackendcommon.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * @author kbws
 * @date 2024/7/17
 * @description: SSE 工具类
 */
@Slf4j
public class SseEmitterUtils {

    private static AtomicInteger count = new AtomicInteger(0);

    private static Map<Long, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    public static SseEmitter connect(Long userId) {
        // 设置超时日期，0表示不过期
        SseEmitter sseEmitter = new SseEmitter(0L);
        // 注册回调
        sseEmitter.onCompletion(completionCallBack(userId));
        sseEmitter.onError(errorCallBack(userId));
        sseEmitter.onTimeout(timeoutCallBack(userId));
        sseEmitterMap.put(userId, sseEmitter);
        count.getAndIncrement();
        log.info("创建新的SSE连接，连接用户编号：{}", userId);
        log.info("现有连接用户：{}", sseEmitterMap.keySet());
        return sseEmitter;
    }

    public static void sendMessage(Long userId, String message) {
        if (!sseEmitterMap.containsKey(userId)) {
            log.error("该连接不存在，{}", sseEmitterMap.keySet());
        }
        try {
            sseEmitterMap.get(userId).send(message);
            log.info("给 {} 发送消息", userId);
        } catch (IOException | NullPointerException e) {
            log.info("userId: {}, 发送消息出错: {}", userId, message);
        }
    }

    /**
     * 群发消息
     */
    public static void batchSendMessage(String message) {
        if (sseEmitterMap != null && !sseEmitterMap.isEmpty()) {
            sseEmitterMap.forEach((k, v) -> {
                try {
                    v.send(message, MediaType.APPLICATION_JSON);
                } catch (IOException e) {
                    log.error("userId:{},发送信息出错:{}", k, e.getMessage());
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 移出用户
     */
    public static void removeUser(Long userId) {
        sseEmitterMap.remove(userId);
        count.getAndDecrement();
        log.info("remove user id:{}", userId);
        log.info("remain user id:" + sseEmitterMap.keySet());
    }

    public static List<Long> getIds() {
        return new ArrayList<>(sseEmitterMap.keySet());
    }

    public static int getUserCount() {
        return count.intValue();
    }

    private static Runnable completionCallBack(Long userId) {
        return () -> {
            log.info("结束连接,{}", userId);
            removeUser(userId);
        };
    }

    private static Runnable timeoutCallBack(Long userId) {
        return () -> {
            log.info("连接超时,{}", userId);
            removeUser(userId);
        };
    }

    private static Consumer<Throwable> errorCallBack(Long userId) {
        return throwable -> {
            log.error("连接异常,{}", userId);
            removeUser(userId);
        };
    }
}
