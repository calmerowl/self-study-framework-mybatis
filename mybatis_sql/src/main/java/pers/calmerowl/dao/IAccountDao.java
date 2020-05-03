package pers.calmerowl.dao;

import pers.calmerowl.domain.Account;
import pers.calmerowl.domain.AccountUser;

import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/5/2 22:04
 * @version: 1.0.0
 */
public interface IAccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
