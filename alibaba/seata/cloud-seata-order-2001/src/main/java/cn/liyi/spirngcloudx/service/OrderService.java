package cn.liyi.spirngcloudx.service;

import cn.liyi.spirngcloudx.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2020/7/23 9:56
 * @Created by liyi
 */
public interface OrderService extends IService<Order> {
    /**
     * 创建订单
     *
     * @param userId
     * @param productId
     * @param num
     * @return
     */
    Boolean createOrder(Long userId, Long productId, Integer num);
}
