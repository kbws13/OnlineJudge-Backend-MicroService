package xyz.kbws.ojbackendjudgeservice.judge.codesandbox.impl;


import xyz.kbws.ojbackendjudgeservice.judge.codesandbox.CodeSandBox;
import xyz.kbws.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import xyz.kbws.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import xyz.kbws.ojbackendmodel.model.codesandbox.JudgeInfo;
import xyz.kbws.ojbackendmodel.model.enums.JudgeInfoMessageEnum;
import xyz.kbws.ojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 示例代码沙箱
 */
public class ExampleCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }

}
