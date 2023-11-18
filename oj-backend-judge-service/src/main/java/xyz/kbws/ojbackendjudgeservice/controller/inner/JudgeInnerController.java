package xyz.kbws.ojbackendjudgeservice.controller.inner;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.kbws.ojbackendjudgeservice.judge.JudgeService;
import xyz.kbws.ojbackendmodel.model.entity.QuestionSubmit;
import xyz.kbws.ojbackendserviceclient.service.JudgeFeignClient;

import javax.annotation.Resource;

/**
 * @author kbws
 * @date 2023/11/18
 * @description:
 */
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId){
        return judgeService.doJudge(questionSubmitId);
    }
}
