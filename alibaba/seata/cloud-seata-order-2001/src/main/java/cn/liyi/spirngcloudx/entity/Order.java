package cn.liyi.spirngcloudx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2020/7/23 9:12
 * @Created by liyi
 */
@Data
@Accessors(chain = true)
@TableName(value = "x_order")
public class Order {

    /**
     * ID,PK
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额，单位分
     */
    private Integer money;

    /**
     * 状态，创建1，完成2
     */
    private Integer status;

}
