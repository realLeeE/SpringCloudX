package cn.liyi.springcloudx.service;

import cn.liyi.springcloudx.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2020/7/23 14:52
 * @Created by liyi
 */
public interface AccountService extends IService<Account> {
    /**
     * 扣减余额
     *
     * @param mid
     * @param money
     * @return
     */
    Boolean subtractMoney(Long mid, Integer money);
}
