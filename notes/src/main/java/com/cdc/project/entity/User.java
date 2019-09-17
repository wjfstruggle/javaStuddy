package com.cdc.project.entity;

import java.util.Date;

/**
 * @program: notes
 * @description: 数据层
 * @author: wujf
 * @create: 2019-08-19 14:34
 **/
public class User {
    private int id;
    private String name;
    private String sex;
    private Date birthday;

    public User() {

    }

    public User(int id, String name, String sex, Date birthday) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toSstring() {
        return "";
    }
}
