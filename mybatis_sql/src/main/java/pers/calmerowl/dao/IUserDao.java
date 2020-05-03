package pers.calmerowl.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.calmerowl.domain.QueryVo;
import pers.calmerowl.domain.User;

import java.util.List;

/**
 * @author: calmerowl
 * @date: 2020/4/28 16:44
 * @version: 1.0.0
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

//    /**
//     * 保存用户
//     * @param user
//     */
//    void saveUser(User user);
//
//    /**
//     * 更新用户
//     * @param user
//     */
//    void updateUser(User user);
//
//    /**
//     * 删除用户
//     * @param userId
//     */
//    void deleteUser(Integer userId);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

//    /**
//     * 根据名称模糊查询用户信息
//     * @param username
//     * @return
//     */
//    List<User> findByName(String username);
//
//    /**
//     * 根据queryVo中的条件查询用户
//     * @param vo
//     * @return
//     */
//    List<User> findUserByVo(QueryVo vo);
//
//    /**
//     * 根据传入参数条件
//     * @param user 查询的条件：有可能有用户名，有可能有性别，也有可能有地址，还有可能是都有
//     * @return
//     */
//    List<User> findUserByCondition(User user);
//
//    /**
//     * 根据queryvo中提供的id集合，查询用户信息
//     * @param vo
//     * @return
//     */
//    List<User> findUserInIds(QueryVo vo);
}
