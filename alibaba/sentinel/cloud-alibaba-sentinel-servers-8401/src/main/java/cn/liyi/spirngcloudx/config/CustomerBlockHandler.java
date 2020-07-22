package cn.liyi.spirngcloudx.config;

import cn.liyi.springcloudx.entity.R;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Classname CustomerBlockHandler
 * @Description TODO
 * @Date 2020/7/22 13:39
 * @Created by liyi
 */
public class CustomerBlockHandler {

    public static R<?> handlerException(BlockException exception) {
        return new R<>(4444, "按客戶自定义,global handlerException----1");
    }

    public static R<?> handlerException2(BlockException exception) {
        return new R<>(4444, "按客戶自定义,global handlerException----2");
    }

}
