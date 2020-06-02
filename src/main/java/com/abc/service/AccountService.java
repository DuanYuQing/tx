package com.abc.service;

import com.abc.domain.Account;

/**
 * 业务层。
 */
public interface AccountService {
    /**
     * 根据账户id查询账户。
     *
     * @param id 账户id。
     * @return 某个账户。
     */
    Account findAccountById(Integer id);

    /**
     * 转账。
     *
     * @param srcAccountName 转出账户名称。
     * @param trgAccountName 转入账户名称。
     * @param money          转账金额。
     */
    void transfer(String srcAccountName, String trgAccountName, Float money);
}
