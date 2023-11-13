package xyz.kbws.ojbackendjudgeservice.judge.strategy;

import lombok.Data;
import xyz.kbws.ojbackendmodel.model.codesandbox.JudgeInfo;
import xyz.kbws.ojbackendmodel.model.dto.question.JudgeCase;
import xyz.kbws.ojbackendmodel.model.entity.Question;
import xyz.kbws.ojbackendmodel.model.entity.QuestionSubmit;

import java.util.List;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
