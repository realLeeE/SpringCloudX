package cn.liyi.springcloudx.api.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname ProductResponse
 * @Description TODO
 * @Date 2020/7/23 14:25
 * @Created by liyi
 */
@Data
@Accessors(chain = true)
public class ProductResponse {

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 单价，单位分
     */
    private Integer price;

    /**
     * 剩余库存
     */
    private Integer residue;


}
