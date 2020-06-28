package com.taobao.demo.service;

import com.taobao.demo.entity.StudentCard;

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
