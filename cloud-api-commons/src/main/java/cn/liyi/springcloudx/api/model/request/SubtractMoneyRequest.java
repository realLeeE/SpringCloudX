package cn.liyi.springcloudx.api.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname subtractMoneyRequest
 * @Description TODO
 * @Date 2020/7/23 15:02
 * @Created by liyi
 */
@Data
@Accessors(chain = true)
public class SubtractMoneyRequest {

    /**
     * 用户ID
     */
    private Long mid;

    /**
     * 金额
     */
    private Integer money;

}
