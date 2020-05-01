package pers.calmerowl.dao;

import com.google.protobuf.Internal;
import org.apache.ibatis.annotations.*;
import pers.calmerowl.domain.QueryVo;
import pers.calmerowl.domain.User;

import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/4/30 23:35
 * @version: 1.0.0
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser( Integer userId);

    /**
     * 查询总用户数
     * @return
     */
    @Select("select count(id) from user")
    int findTotal();

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    @Select("select * from user where username like #{name}")
    List<User> findByName(String username);

    /**
     * 根据QueryVo中的条件查询用户
     * @return
     */
    @Select("select * from user where username like #{user.username}")
    List<User> findUserByQueryVo(QueryVo queryVo);
}
