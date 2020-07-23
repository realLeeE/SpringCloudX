package cn.liyi.spirngcloudx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname entity
 * @Description TODO
 * @Date 2020/7/23 12:08
 * @Created by liyi
 */
@Data
@Accessors(chain = true)
@TableName(value = "x_storage")
public class Storage {

    /**
     * ID,PK
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 单价，单位分
     */
    private Integer price;

    /**
     * 总数量
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
