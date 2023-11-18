package xyz.kbws.ojbackendquestionservice.controller.inner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.kbws.ojbackendmodel.model.entity.Question;
import xyz.kbws.ojbackendmodel.model.entity.QuestionSubmit;
import xyz.kbws.ojbackendquestionservice.service.QuestionService;
import xyz.kbws.ojbackendquestionservice.service.QuestionSubmitService;
import xyz.kbws.ojbackendserviceclient.service.QuestionFeignClient;

import javax.annotation.Resource;

/**
 * @author kbws
 * @date 2023/11/18
 * @description:
 */
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId) {
        return questionService.getById(questionId);
    }

    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId) {
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmit(@RequestBody QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }
}
