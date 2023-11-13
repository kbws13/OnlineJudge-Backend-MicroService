package xyz.kbws.ojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @author kbws
 * @date 2023/10/16
 * @description: 题目配置
 */
@Data
public class JudgeConfig {

    /**
     * 时间限制 (ms)
     */
    private Long timeLimit;

    /**
     * 内存限制 (kb)
     */
    private Long memoryLimit;

    /**
     * 堆栈限制 (kb)
     */
    private Long stackLimit;
}
