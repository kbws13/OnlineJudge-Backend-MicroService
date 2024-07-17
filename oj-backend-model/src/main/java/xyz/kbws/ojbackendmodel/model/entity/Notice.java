package xyz.kbws.ojbackendmodel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kbws
 * @date 2024/7/17
 * @description: 消息通知类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

    private Long userId;

    private String message;

}
