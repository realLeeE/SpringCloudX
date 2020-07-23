package cn.liyi.spirngcloudx.mapper;

import cn.liyi.spirngcloudx.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname OrderMapper
 * @Description TODO
 * @Date 2020/7/23 9:16
 * @Created by liyi
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
