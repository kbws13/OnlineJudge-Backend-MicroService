package xyz.kbws.ojbackenduserservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.kbws.ojbackendcommon.common.ErrorCode;
import xyz.kbws.ojbackendcommon.exception.BusinessException;
import xyz.kbws.ojbackendcommon.exception.ThrowUtils;
import xyz.kbws.ojbackendmodel.model.entity.UserCode;
import xyz.kbws.ojbackenduserservice.mapper.UserCodeMapper;
import xyz.kbws.ojbackenduserservice.service.UserCodeService;

/**
 * @author kbws
 * @date 2024/2/27
 * @description:
 */
@Service
public class UserCodeServiceImpl extends ServiceImpl<UserCodeMapper, UserCode>
        implements UserCodeService {
    @Override
    public UserCode getUserCodeByUserId(long userId) {
        if (userId < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserCode> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId);
        UserCode userCode = this.getOne(wrapper);
        ThrowUtils.throwIf(userCode == null, ErrorCode.NULL_ERROR, "此用户不存在");
        return userCode;
    }
}
