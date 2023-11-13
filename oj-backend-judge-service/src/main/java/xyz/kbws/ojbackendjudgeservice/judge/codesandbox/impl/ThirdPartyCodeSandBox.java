package xyz.kbws.ojbackendjudgeservice.judge.codesandbox.impl;


import xyz.kbws.ojbackendjudgeservice.judge.codesandbox.CodeSandBox;
import xyz.kbws.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import xyz.kbws.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 第三方代码沙箱
 */
public class ThirdPartyCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
