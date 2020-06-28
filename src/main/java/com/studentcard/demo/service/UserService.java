package com.studentcard.demo.service;

import com.studentcard.demo.entity.User;

import java.util.List;

/**
 * @author create by zhaoxu
 * @create 2020/6/27
 */
public interface UserService {
    User findUserByUserNameAndPswd(String userName,String passWord);
    List<User> findUserListByName(String name);
    Integer saveUser(User user);
    Integer delUser(Integer uid);
    Integer updateUser(User user);

    User selectByPrimaryKey(Integer uid);

}
