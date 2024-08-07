package xyz.kbws.ojbackendmodel.model.dto.questionsubmit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.kbws.ojbackendcommon.common.PageRequest;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author kbws
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 题目 id
     */
    private Long questionId;
    /**
     * 提交状态
     */
    private Integer submitState;
    /**
     * 编程语言
     */
    private String submitLanguage;
    /**
     * 用户id
     */
    private Long userId;
}