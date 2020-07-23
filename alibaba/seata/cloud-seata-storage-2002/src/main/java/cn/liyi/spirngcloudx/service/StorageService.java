package cn.liyi.spirngcloudx.service;

import cn.liyi.spirngcloudx.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/7/23 14:06
 * @Created by liyi
 */
public interface StorageService extends IService<Storage> {
    /**
     * 扣减库存
     *
     * @param productId
     * @param num
     * @return
     */
    Boolean subtractStorage(Long productId, Integer num);
}
