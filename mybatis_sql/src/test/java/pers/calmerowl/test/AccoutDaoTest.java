package pers.calmerowl.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.calmerowl.dao.IAccountDao;
import pers.calmerowl.dao.IUserDao;
import pers.calmerowl.domain.Account;
import pers.calmerowl.domain.AccountUser;
import pers.calmerowl.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/5/2 22:14
 * @version: 1.0.0
 */
public class AccoutDaoTest {

    private InputStream inputStream;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before//在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory对象
        //factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.使用工厂生产SqlSession对象
        //session = factory.openSession();
        session = new SqlSessionFactoryBuilder().build(inputStream).openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After//在测试方法后执行
    public void destory() throws Exception{
        //提交事务
        //session.commit();
        session.close();
        inputStream.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts){
            System.out.println("--------每个account的信息------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


    /**
     * 测试查询所有账户，同时包含用户名称和地址
     */
    @Test
    public void testFindAllAccountUser(){
        List<AccountUser> aus = accountDao.findAllAccount();
        for(AccountUser au : aus){
            System.out.println(au);
        }
    }
}
