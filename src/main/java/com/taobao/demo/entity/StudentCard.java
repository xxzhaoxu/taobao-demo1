package com.taobao.demo.entity;

import java.util.Date;

public class StudentCard {
    private Integer sid;

    private String name;

    private String sNo;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date headImg;

    private String school;

    private String professional;

    private String gender;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Date headImg) {
        this.headImg = headImg;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public StudentCard(String name, String sNo, Date startTime, Date endTime, Date createTime, String school, String professional, String gender) {
        this.name = name;
        this.sNo = sNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.school = school;
        this.professional = professional;
        this.gender = gender;
    }
    public StudentCard(){

    }
}