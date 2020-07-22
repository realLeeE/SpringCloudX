package cn.liyi.springcloudx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname Payment
 * @Description TODO
 * @Date 2020/7/9 9:45
 * @Created by liyi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = 7601942019591390926L;
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
