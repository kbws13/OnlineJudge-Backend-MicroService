package xyz.kbws.ojbackendmodel.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author kbws
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 编程语言
     */
    private String submitLanguage;

    /**
     * 用户代码
     */
    private String submitCode;

    private static final long serialVersionUID = 1L;
}