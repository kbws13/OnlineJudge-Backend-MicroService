package xyz.kbws.ojbackendmodel.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kbws
 * @date 2024/2/14
 * @description: 用户编号
 */
@Data
public class UserCodeVO extends UserVO implements Serializable {
    /**
     * id
     */
    private Long id;


    private static final long serialVersionUID = 1L;
}
