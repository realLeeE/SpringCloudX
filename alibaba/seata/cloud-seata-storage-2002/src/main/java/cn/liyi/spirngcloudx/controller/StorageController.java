package cn.liyi.spirngcloudx.controller;

import cn.liyi.spirngcloudx.entity.Storage;
import cn.liyi.spirngcloudx.service.StorageService;
import cn.liyi.springcloudx.api.StorageApi;
import cn.liyi.springcloudx.api.model.request.SubtractStorageRequest;
import cn.liyi.springcloudx.api.model.response.ProductResponse;
import cn.liyi.springcloudx.entity.R;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname StorageController
 * @Description TODO
 * @Date 2020/7/23 14:08
 * @Created by liyi
 */
@RestController
@Slf4j
public class StorageController implements StorageApi {

    @Autowired
    private StorageService storageService;

    /**
     * 查询库存信息
     *
     * @param productId
     * @return
     */
    @Override
    public R<ProductResponse> get(Long productId) {
        log.info("-------------------- get productId: {}", productId);
        Storage product = storageService.getOne(Wrappers.<Storage>lambdaQuery()
                .eq(Storage::getProductId, productId)
                .last(" limit 1 "));
        return product == null ? new R<>() : new R<>(new ProductResponse()
                .setProductId(product.getProductId())
                .setPrice(product.getPrice())
                .setResidue(product.getResidue())
        );
    }

    /**
     * 扣减库存
     *
     * @param request
     * @return
     */
    @Override
    public R<?> subtractStorage(@RequestBody SubtractStorageRequest request) {
        log.info("-------------------- subtractStorage SubtractStorageRequest: {}", request);
        Boolean success = storageService.subtractStorage(request.getProductId(), request.getNum());
        return new R<>();
    }
}
