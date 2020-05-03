package pers.calmerowl.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.calmerowl.dao.IUserDao;
import pers.calmerowl.domain.QueryVo;
import pers.calmerowl.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/4/28 17:40
 * @version: 1.0.0
 * mybatis的入门案例
 */
public class UserDaoTest {

//    /**
//     * 入门案例
//     * @param args
//     */
//    public static void main(String[] args)throws Exception{
//        //1.读取配置文件
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2.创建SqlSessionFactory对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(inputStream);
//        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
//        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao userDao = session.getMapper(IUserDao.class);
//        //5.使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for(User user : users){
//            System.out.println(user);
//        }
//        //6.释放资源
//        session.close();
//        inputStream.close();
//    }

    private InputStream inputStream;
    //private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

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
        userDao = session.getMapper(IUserDao.class);
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
    public void testFindAll() throws IOException {
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        System.out.println("hello,mybatis crud, test findAll method!");
    }

//    /**
//     * 测试保存用户
//     */
//    @Test
//    public void testSaveUser() throws IOException {
//        User user =new User();
//        user.setUsername("calmerowl");
//        user.setAddress("nc");
//        user.setSex("男");
//        user.setBirthday(new Date());
//        userDao.saveUser(user);
//        System.out.println("hello,mybatis crud, test saveUser method!");
//    }
//
//    /**
//     * 测试更新用户
//     */
//    @Test
//    public void testUpdateUser(){
//        User user =new User();
//        user.setId(41);
//        user.setUsername("calmerowl");
//        user.setAddress("nc");
//        user.setSex("男");
//        user.setBirthday(new Date());
//        userDao.updateUser(user);
//        System.out.println("hello,mybatis crud, test updateUser method!");
//    }
//
//    /**
//     * 测试删除用户
//     */
//    @Test
//    public void testDeleteUser(){
//        userDao.deleteUser(52);
//        System.out.println("hello,mybatis crud, test deleteUser method!");
//    }

    /**
     * 测试根据Id查询用户
     */
    public void testFindById(){
        User  user = userDao.findById(50);
        System.out.println(user);
    }

//    /**
//     * 测试模糊查询操作
//     */
//    @Test
//    public void testFindByName(){
//        //5.执行查询一个方法
//        List<User> users = userDao.findByName("%王%");
////        List<User> users = userDao.findByName("王");
//        for(User user : users){
//            System.out.println(user);
//        }
//    }
//
//    /**
//     * 测试使用QueryVo作为查询条件
//     */
//    @Test
//    public void testFindByVo() {
//        QueryVo vo = new QueryVo();
//        User user = new User();
//        user.setUsername("%王%");
//        vo.setUser(user);
//        //5.执行查询一个方法
//        List<User> users = userDao.findUserByVo(vo);
//        for (User u : users) {
//            System.out.println(u);
//        }
//    }
//
//    /**
//     * 测试查询所有
//     */
//    @Test
//    public void testFindByCondition(){
//        User u = new User();
//        u.setUsername("老王");
////        u.setUserSex("女");
//
//        //5.执行查询所有方法
//        List<User> users = userDao.findUserByCondition(u);
//        for(User user : users){
//            System.out.println(user);
//        }
//
//    }
//
//
//    /**
//     * 测试foreach标签的使用
//     */
//    @Test
//    public void testFindInIds(){
//        QueryVo vo = new QueryVo();
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(41);
//        list.add(42);
//        list.add(46);
//        vo.setIds(list);
//
//
//        //5.执行查询所有方法
//        List<User> users = userDao.findUserInIds(vo);
//        for(User user : users){
//            System.out.println(user);
//        }
//
//    }

}
