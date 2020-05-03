package pers.calmerowl.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.calmerowl.dao.IUserDao;
import pers.calmerowl.dao.impl.UserDaoImpl;
import pers.calmerowl.domain.QueryVo;
import pers.calmerowl.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/4/30 23:38
 * @version: 1.0.0
 */
public class IUserDaoTest {

    private InputStream inputStream;
    private IUserDao userDao;

    @Before//在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After//在测试方法后执行
    public void destory() throws Exception{
        inputStream.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws IOException {
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        System.out.println("hello,mybatis daoimp, test findAll method!");
    }

    /**
     * 测试保存用户
     */
    @Test
    public void testSaveUser() throws IOException {
        User user =new User();
        user.setUsername("calmerowl");
        user.setAddress("nc");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
        System.out.println("hello,mybatis daoimp, test saveUser method!");
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser(){
        User user =new User();
        user.setId(41);
        user.setUsername("calmerowl");
        user.setAddress("nc");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
        System.out.println("hello,mybatis daoimp, test updateUser method!");
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(52);
        System.out.println("hello,mybatis daoimp, test deleteUser method!");
    }

    /**
     * 测试用户的总记录条数
     */
    @Test
    public void testFindTotal(){
       int iTotal = userDao.findTotal();
       System.out.println("total:"+iTotal);
       System.out.println("hello,mybatis daoimp, test findTotal method!");
    }

    /**
     * 测试根据名称模糊查询用户信息
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%calmer%");
        for(User user : users){
            System.out.println(user);
        }
        System.out.println("hello,mybatis daoimp, test findByName method!");
    }
}
