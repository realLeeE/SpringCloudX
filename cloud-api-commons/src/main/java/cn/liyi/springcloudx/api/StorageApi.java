package cn.liyi.springcloudx.api;

import cn.liyi.springcloudx.api.model.request.SubtractStorageRequest;
import cn.liyi.springcloudx.api.model.response.ProductResponse;
import cn.liyi.springcloudx.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname StorageApi
 * @Description TODO
 * @Date 2020/7/23 14:23
 * @Created by liyi
 */
@Component
@FeignClient(value = "cloud-seata-storage")
public interface StorageApi {


    /**
     * 查询库存信息
     *
     * @param productId
     * @return
     */
    @GetMapping(value = "/storage/get", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<ProductResponse> get(@RequestParam(value = "productId") Long productId);

    /**
     * 扣减库存
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/storage/subtract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    R<?> subtractStorage(@RequestBody SubtractStorageRequest request);

}
