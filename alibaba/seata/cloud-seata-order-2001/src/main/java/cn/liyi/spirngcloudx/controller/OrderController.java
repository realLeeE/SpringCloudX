package cn.liyi.spirngcloudx.controller;

import cn.liyi.spirngcloudx.service.OrderService;
import cn.liyi.springcloudx.api.OrderApi;
import cn.liyi.springcloudx.api.model.request.CreateOrderRequest;
import cn.liyi.springcloudx.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/7/23 10:35
 * @Created by liyi
 */
@RestController
@Slf4j
public class OrderController implements OrderApi {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param request
     * @return
     */
    @Override
    public R<?> create(@RequestBody CreateOrderRequest request) {
        log.info("--------------- create CreateOrderRequest:{}", request);
        Boolean order = orderService.createOrder(request.getUserId(), request.getProductId(), request.getNum());
        return new R<>(order);
    }
}
