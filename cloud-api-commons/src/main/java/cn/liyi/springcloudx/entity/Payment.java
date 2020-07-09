package cn.liyi.springcloudx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname Payment
 * @Description TODO
 * @Date 2020/7/9 9:45
 * @Created by liyi
 */
@Data
public class Payment implements Serializable {

    /**
     * ID,PK
     */
//    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 流水号
     */
    private String serial;
}
