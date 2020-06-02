package com.abc.dao;

import com.abc.domain.Account;

/**
 * 持久层。
 */
public interface AccountDao {
    /**
     * 根据账户id查询账户。
     *
     * @param id 账户id。
     * @return 某个账户。
     */
    Account findAccountById(Integer id);

    /**
     * 根据账户name查询账户。
     *
     * @param name 账户名。
     * @return 某个账户。
     */
    Account findAccountByName(String name);

    /**
     * 更新某账户。
     *
     * @param account 新的账户。
     */
    void updateAccount(Account account);
}
