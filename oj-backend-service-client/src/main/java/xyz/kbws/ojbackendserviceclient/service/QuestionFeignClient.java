package xyz.kbws.ojbackendserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.kbws.ojbackendmodel.model.entity.Question;
import xyz.kbws.ojbackendmodel.model.entity.QuestionSubmit;

/**
* @author hsy
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-10-16 21:27:46
*/
@FeignClient(name = "oj-backend-question-service", path = "/api/question/inner")
public interface QuestionFeignClient{

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmit(@RequestBody QuestionSubmit questionSubmit);
}
