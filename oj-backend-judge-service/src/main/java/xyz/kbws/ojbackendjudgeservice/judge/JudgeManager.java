package xyz.kbws.ojbackendjudgeservice.judge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.kbws.ojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import xyz.kbws.ojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import xyz.kbws.ojbackendjudgeservice.judge.strategy.JudgeContext;
import xyz.kbws.ojbackendjudgeservice.judge.strategy.JudgeStrategy;
import xyz.kbws.ojbackendmodel.model.codesandbox.JudgeInfo;
import xyz.kbws.ojbackendmodel.model.entity.QuestionSubmit;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 判题管理（简化调用）
 */
@Slf4j
@Service
public class JudgeManager {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
