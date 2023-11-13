package xyz.kbws.ojbackendmodel.model.codesandbox;

import lombok.Data;

/**
 * @author kbws
 * @date 2023/10/16
 * @description: 题目配置
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memory;

    /**
     * 时间
     */
    private Long time;
}
