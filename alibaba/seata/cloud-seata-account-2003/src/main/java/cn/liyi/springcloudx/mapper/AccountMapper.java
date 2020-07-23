package cn.liyi.springcloudx.mapper;

import cn.liyi.springcloudx.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Classname AccountMapper
 * @Description TODO
 * @Date 2020/7/23 14:52
 * @Created by liyi
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 扣减用户余额
     *
     * @param mid
     * @param money
     * @return
     */
    @Update(" update x_account set used=used+${money},residue=residue-${money} where id=${mid} and residue-${money}>=0")
    int subtractMoney(@Param("mid") Long mid, @Param("money") Integer money);
}
