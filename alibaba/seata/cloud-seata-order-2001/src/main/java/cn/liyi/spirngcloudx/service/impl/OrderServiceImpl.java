package cn.liyi.spirngcloudx.service.impl;

import cn.liyi.spirngcloudx.entity.Order;
import cn.liyi.spirngcloudx.mapper.OrderMapper;
import cn.liyi.spirngcloudx.service.OrderService;
import cn.liyi.springcloudx.api.AccountApi;
import cn.liyi.springcloudx.api.StorageApi;
import cn.liyi.springcloudx.api.model.request.SubtractMoneyRequest;
import cn.liyi.springcloudx.api.model.request.SubtractStorageRequest;
import cn.liyi.springcloudx.api.model.response.ProductResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/7/23 9:56
 * @Created by liyi
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StorageApi storageApi;
    @Autowired
    private AccountApi accountApi;

    /**
     * 创建订单
     *
     * @param userId
     * @param productId
     * @param num
     * @return
     */
    @Override
    public Boolean createOrder(Long userId, Long productId, Integer num) {
        // 查询商品价格库存等
        ProductResponse product = storageApi.get(productId).getData();

        // 扣减库存
        storageApi.subtractStorage(new SubtractStorageRequest().setProductId(productId).setNum(num));

        // 创建订单
        int money = product.getPrice() * num;
        Order order = new Order().setUserId(userId).setProductId(productId).setMoney(money).setCount(num).setStatus(1);
        int insert = orderMapper.insert(order);

        // 扣减余额
        accountApi.subtractMoney(new SubtractMoneyRequest().setMid(userId).setMoney(money));

        // 完成订单
        int success = orderMapper.updateById(new Order().setId(order.getId()).setStatus(2));

        return retBool(success);
    }
}
