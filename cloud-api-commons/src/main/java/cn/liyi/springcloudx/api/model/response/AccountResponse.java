package cn.liyi.springcloudx.api.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname AccountResponse
 * @Description TODO
 * @Date 2020/7/23 14:58
 * @Created by liyi
 */
@Data
@Accessors(chain = true)
public class AccountResponse {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 余额
     */
    private Integer residue;

}
