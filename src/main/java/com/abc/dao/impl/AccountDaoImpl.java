package com.abc.dao.impl;

import com.abc.dao.AccountDao;
import com.abc.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    // 有了extends JdbcDaoSupport就不需要在每个Dao中都分别地注入JdbcTemplate对象了
    // 优化了编码，用于解决多个Dao中重复代码，代价是不能用基于注解的Spring配置了
    /*@Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;*/

    /**
     * 根据账户id查询账户。
     *
     * @param id 账户id。
     * @return 某个账户。
     */
    public Account findAccountById(Integer id) {
        List<Account> accounts = super.getJdbcTemplate().query("SELECT * FROM t_account WHERE `id` = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    /**
     * 根据账户name查询账户。
     *
     * @param name 账户名。
     * @return 某个账户。
     */
    public Account findAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("SELECT * FROM t_account WHERE `name` = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集重复");
        }
        return accounts.get(0);
    }

    /**
     * 更新某账户。
     *
     * @param account 新的账户。
     */
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("UPDATE t_account SET `name` = ?, `money` = ? WHERE `id` = ?", account.getName(), account.getMoney(), account.getId());
    }
}
