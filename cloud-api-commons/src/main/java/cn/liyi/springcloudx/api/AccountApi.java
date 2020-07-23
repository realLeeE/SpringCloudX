package cn.liyi.springcloudx.api;

import cn.liyi.springcloudx.api.model.request.SubtractMoneyRequest;
import cn.liyi.springcloudx.api.model.response.AccountResponse;
import cn.liyi.springcloudx.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname AccountApi
 * @Description TODO
 * @Date 2020/7/23 14:57
 * @Created by liyi
 */
@Component
@FeignClient(value = "account-service")
public interface AccountApi {

    /**
     * 根据用户ID查询用户账户余额
     *
     * @param mid
     * @return
     */
    @GetMapping(value = "/account/get", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<AccountResponse> get(@RequestParam(value = "mid") Long mid);

    /**
     * 扣减余额
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/account/subtract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<?> subtractMoney(@RequestBody SubtractMoneyRequest request);

}
