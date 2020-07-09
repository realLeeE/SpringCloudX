package cn.liyi.springcloudx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Classname R
 * @Description 响应模型
 * @Date 2020/7/9 9:47
 * @Created by liyi
 */
@Data
@AllArgsConstructor
public class R<T> {

    private Integer code;

    private String msg;

    private T data;

    public R() {
        this.code = 200;
        this.msg = "OK";
    }

    public R(Integer code, String msg) {
        this(code, msg, null);
    }

    public R(T data) {
        this(200, "OK", data);
    }
}
