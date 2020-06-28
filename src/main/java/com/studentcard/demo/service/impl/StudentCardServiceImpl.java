package com.studentcard.demo.service.impl;

import com.studentcard.demo.service.StudentCardService;
import com.studentcard.demo.entity.StudentCard;
import com.studentcard.demo.mapper.StudentCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author create by zhaoxu
 * @create 2020/6/27
 */

@Service("studentCardService")
public class StudentCardServiceImpl implements StudentCardService {
    @Autowired
    private StudentCardMapper studentCardMapper;
    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return studentCardMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int insertSelective(StudentCard record) {
        return studentCardMapper.insertSelective(record);
    }

    @Override
    public StudentCard selectByPrimaryKey(Integer sid) {
        return studentCardMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int updateByPrimaryKeySelective(StudentCard record) {
        return studentCardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<StudentCard> selectStudentCard(StudentCard studentCard) {
        return studentCardMapper.selectStudentCard(studentCard);
    }
}
