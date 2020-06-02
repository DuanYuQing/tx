package com.abc.service.impl;

import com.abc.dao.AccountDao;
import com.abc.domain.Account;
import com.abc.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据账户id查询账户。
     *
     * @param id 账户id。
     * @return 某个账户。
     */
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    /**
     * 转账。
     *
     * @param srcAccountName 转出账户名称。
     * @param trgAccountName 转入账户名称。
     * @param money          转账金额。
     */
    public void transfer(String srcAccountName, String trgAccountName, Float money) {
        Account srcAccount = accountDao.findAccountByName(srcAccountName);
        Account trgAccount = accountDao.findAccountByName(trgAccountName);
        srcAccount.setMoney(srcAccount.getMoney() - money);
        trgAccount.setMoney(trgAccount.getMoney() + money);
        accountDao.updateAccount(trgAccount);
        // int i = 1 / 0;
        accountDao.updateAccount(srcAccount);
    }
}
