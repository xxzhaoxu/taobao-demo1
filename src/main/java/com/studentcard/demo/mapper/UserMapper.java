package com.studentcard.demo.mapper;

import com.studentcard.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    User selectByNameAndPswd(@Param("userName")String userName,@Param("passWord")String passWord);

    List<User> selectUserListByName(@Param("userName")String userName);
}