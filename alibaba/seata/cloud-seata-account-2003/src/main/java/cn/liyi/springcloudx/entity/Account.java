package cn.liyi.springcloudx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname Account
 * @Description TODO
 * @Date 2020/7/23 14:49
 * @Created by liyi
 */
@Data
@TableName(value = "x_account")
public class Account {

    /**
     * ID,PK
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 总额度
     */
    private Integer total;

    /**
     * 已用
     */
    private Integer used;

    /**
     * 余额
     */
    private Integer residue;

}
