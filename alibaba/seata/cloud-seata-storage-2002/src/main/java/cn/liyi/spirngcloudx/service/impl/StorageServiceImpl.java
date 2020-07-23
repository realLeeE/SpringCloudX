package cn.liyi.spirngcloudx.service.impl;

import cn.liyi.spirngcloudx.entity.Storage;
import cn.liyi.spirngcloudx.mapper.StorageMapper;
import cn.liyi.spirngcloudx.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public Boolean subtractStorage(Long productId, Integer num) {
        return retBool(baseMapper.subtractStorage(productId, num));
    }
}
