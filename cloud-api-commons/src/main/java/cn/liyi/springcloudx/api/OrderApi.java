package cn.liyi.springcloudx.api;

import cn.liyi.springcloudx.api.model.request.CreateOrderRequest;
import cn.liyi.springcloudx.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Classname OrderApi
 * @Description TODO
 * @Date 2020/7/23 14:12
 * @Created by liyi
 */
@Component
@FeignClient(value = "order-service")
public interface OrderApi {

    /**
     * 创建订单
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/order/create", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<?> create(@RequestBody CreateOrderRequest request);


}
