package com.taobao.demo.mapper;

import com.taobao.demo.entity.StudentCard;

import java.util.List;

public interface StudentCardMapper {
    int deleteByPrimaryKey(Integer sid);

    int insertSelective(StudentCard record);

    StudentCard selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(StudentCard record);

    List<StudentCard> selectStudentCard(StudentCard studentCard);
}