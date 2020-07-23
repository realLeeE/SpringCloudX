package cn.liyi.springcloudx.controller;

import cn.liyi.springcloudx.api.AccountApi;
import cn.liyi.springcloudx.api.model.request.SubtractMoneyRequest;
import cn.liyi.springcloudx.api.model.response.AccountResponse;
import cn.liyi.springcloudx.entity.Account;
import cn.liyi.springcloudx.entity.R;
import cn.liyi.springcloudx.service.AccountService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AccountController
 * @Description TODO
 * @Date 2020/7/23 14:57
 * @Created by liyi
 */
@RestController
@Slf4j
public class AccountController implements AccountApi {

    @Autowired
    private AccountService accountService;

    /**
     * 根据用户ID查询用户账户余额
     *
     * @param mid
     * @return
     */
    @Override
    public R<AccountResponse> get(Long mid) {
        log.info("-------------- get mid:{}", mid);
        Account account = accountService.getOne(Wrappers.<Account>lambdaQuery()
                .eq(Account::getId, mid).last(" limit 1 "));
        return null == account ? new R<>() : new R<>(
                new AccountResponse().setId(account.getId())
                        .setResidue(account.getResidue())
        );
    }

    /**
     * 扣减余额
     *
     * @param request
     * @return
     */
    @Override
    public R<?> subtractMoney(@RequestBody SubtractMoneyRequest request) {
        log.info("-------------- subtractMoney SubtractMoneyRequest:{}", request);
        Boolean success = accountService.subtractMoney(request.getMid(), request.getMoney());
        return null;
    }
}
