package xyz.kbws.ojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @author kbws
 * @date 2023/10/16
 * @description: 题目输入输出用例
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
