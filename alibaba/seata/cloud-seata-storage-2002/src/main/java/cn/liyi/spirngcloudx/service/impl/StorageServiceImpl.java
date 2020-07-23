package cn.liyi.spirngcloudx.service.impl;

import cn.liyi.spirngcloudx.entity.Storage;
import cn.liyi.spirngcloudx.mapper.StorageMapper;
import cn.liyi.spirngcloudx.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname StorageServiceImpl
 * @Description TODO
 * @Date 2020/7/23 14:07
 * @Created by liyi
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    /**
     * 扣减库存
     *
     * @param productId
     * @param num
     * @return
     */
    @Override
    @Transactional
    public Boolean subtractStorage(Long productId, Integer num) {
        boolean success = retBool(baseMapper.subtractStorage(productId, num));
        if (!success) {
            throw new RuntimeException("库存不足");
        }
        return success;
    }
}
