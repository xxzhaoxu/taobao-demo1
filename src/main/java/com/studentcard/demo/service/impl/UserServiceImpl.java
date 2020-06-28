package com.studentcard.demo.service.impl;

import com.studentcard.demo.entity.User;
import com.studentcard.demo.mapper.UserMapper;
import com.studentcard.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author create by zhaoxu
 * @create 2020/6/27
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findUserByUserNameAndPswd(String userName, String passWord) {
        return userMapper.selectByNameAndPswd(userName, passWord);
    }

    @Override
    public List<User> findUserListByName(String name) {
        return userMapper.selectUserListByName(name);
    }

    @Override
    public Integer saveUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public Integer delUser(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}
