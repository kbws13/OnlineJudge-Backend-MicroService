package xyz.kbws.ojbackendmodel.model.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.kbws.ojbackendcommon.common.PageRequest;

import java.io.Serializable;

/**
 * 用户查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户简介
     */
    private String userProfile;
    /**
     * 性别 男 女
     */
    private String gender;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态:正常/注销/封号
     */
    private String userState;
    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;
}