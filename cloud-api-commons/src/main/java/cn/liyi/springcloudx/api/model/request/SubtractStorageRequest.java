package cn.liyi.springcloudx.api.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname SubtractStorageRequest
 * @Description TODO
 * @Date 2020/7/23 14:36
 * @Created by liyi
 */
@Data
@Accessors(chain = true)
public class SubtractStorageRequest {

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer num;

}
