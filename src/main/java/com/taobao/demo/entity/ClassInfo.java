package com.taobao.demo.entity;

import java.util.Objects;

/**
 * @author create by zhaoxu
 * @create 2020/6/25
 */
public class ClassInfo {
    private Long id;
    private String name;
    private String teacherName;
    private String stuNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public ClassInfo(){

    }
    public ClassInfo(Long id, String name, String teacherName, String stuNum) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.stuNum = stuNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassInfo)) {
            return false;
        }
        ClassInfo classInfo = (ClassInfo) o;

        return  classInfo.getName()==name||classInfo.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teacherName, stuNum);
    }
}
