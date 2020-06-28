package com.studentcard.demo.service;

import com.studentcard.demo.entity.StudentCard;

import java.util.List;

/**
 * @author create by zhaoxu
 * @create 2020/6/27
 */
public interface StudentCardService {
    int deleteByPrimaryKey(Integer sid);

    int insertSelective(StudentCard record);

    StudentCard selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(StudentCard record);

    List<StudentCard> selectStudentCard(StudentCard studentCard);

}
