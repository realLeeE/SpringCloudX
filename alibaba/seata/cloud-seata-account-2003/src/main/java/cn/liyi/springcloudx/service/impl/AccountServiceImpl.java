package cn.liyi.springcloudx.service.impl;

import cn.liyi.springcloudx.entity.Account;
import cn.liyi.springcloudx.mapper.AccountMapper;
import cn.liyi.springcloudx.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Classname AccountServiceImpl
 * @Description TODO
 * @Date 2020/7/23 14:53
 * @Created by liyi
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    /**
     * 扣减余额
     *
     * @param mid
     * @param money
     * @return
     */
    @Override
    public Boolean subtractMoney(Long mid, Integer money) {
        return retBool(baseMapper.subtractMoney(mid, money));
    }
}
