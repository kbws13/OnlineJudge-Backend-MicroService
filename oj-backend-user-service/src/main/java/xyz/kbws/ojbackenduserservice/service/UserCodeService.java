package xyz.kbws.ojbackenduserservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.kbws.ojbackendmodel.model.entity.UserCode;

/**
 * @author kbws
 * @date 2024/2/27
 * @description:
 */
public interface UserCodeService extends IService<UserCode> {
    /**
     * 查看用户有无调用次数
     * @param userId
     * @return
     */
    UserCode getUserCodeByUserId(long userId);
}
