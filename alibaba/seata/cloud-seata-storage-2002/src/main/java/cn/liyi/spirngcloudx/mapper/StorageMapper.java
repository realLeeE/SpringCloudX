package cn.liyi.spirngcloudx.mapper;

import cn.liyi.spirngcloudx.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Classname StorageMapper
 * @Description TODO
 * @Date 2020/7/23 12:12
 * @Created by liyi
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * 扣减库存
     *
     * @param productId
     * @param num
     * @return
     */
    @Update(" update x_storage set used=used+${num},residue=residue-${num} where product_id=${productId} and residue-${num}>=0")
    int subtractStorage(@Param("productId") Long productId, @Param("num") Integer num);
}
