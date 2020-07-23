package cn.liyi.springcloudx.api.model.request;

import lombok.Data;

/**
 * @Classname CreateOrderRequest
 * @Description TODO
 * @Date 2020/7/23 14:13
 * @Created by liyi
 */
@Data
public class CreateOrderRequest {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer num;


}
