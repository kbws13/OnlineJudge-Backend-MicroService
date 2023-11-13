package xyz.kbws.ojbackendjudgeservice.judge.codesandbox;

import lombok.extern.slf4j.Slf4j;
import xyz.kbws.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import xyz.kbws.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @author kbws
 * @date 2023/10/31
 * @description:
 */
@Slf4j
public class CodeSandBoxProxy implements CodeSandBox {

    private final CodeSandBox codeSandbox;


    public CodeSandBoxProxy(CodeSandBox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息：" + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
