package com.cdc.springmybastis.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: spring-mybastis
 * @description: 实体用户描述类
 * @author: wujf
 * @create: 2019-09-02 11:36
 **/
@Repository
@Table(name = "user")
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String username;
  private String password;
  private Double money;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Double getMoney() {
    return money;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", money=" + money +
        '}';
  }
}
