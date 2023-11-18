package xyz.kbws.ojbackenduserservice.controller.inner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.kbws.ojbackendmodel.model.entity.User;
import xyz.kbws.ojbackendserviceclient.service.UserFeignClient;
import xyz.kbws.ojbackenduserservice.service.UserService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author kbws
 * @date 2023/11/18
 * @description: 该服务仅内部调用
 */
@RestController
@RequestMapping("/inner")
public class UserInnerController implements UserFeignClient {

    @Resource
    private UserService userService;

    /**
     * 根据 id 获取用户
     *
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") long userId) {
        return userService.getById(userId);
    }

    /**
     * 根据 id 获取用户列表
     *
     * @param idList
     * @return
     */
    @Override
    @GetMapping("/get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList) {
        return userService.listByIds(idList);
    }
}
