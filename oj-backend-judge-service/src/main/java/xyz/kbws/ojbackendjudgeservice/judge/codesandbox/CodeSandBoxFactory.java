package xyz.kbws.ojbackendjudgeservice.judge.codesandbox;

import xyz.kbws.ojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandBox;
import xyz.kbws.ojbackendjudgeservice.judge.codesandbox.impl.RemoteCodeSandBox;
import xyz.kbws.ojbackendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandBox;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 代码沙箱工厂（根据传入的字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandBoxFactory {

    /**
     * 创建代码沙箱实例
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandBox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandBox();
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();
        }
    }
}
