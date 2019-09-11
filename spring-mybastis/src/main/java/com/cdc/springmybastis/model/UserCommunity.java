package com.cdc.springmybastis.model;

import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: spring-mybastis
 * @description: spring boot 实体类
 * @author: wujf
 * @create: 2019-09-06 16:15
 **/
@Repository
@Table(name = "user_community")
public class UserCommunity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String account_id;
  private String name;
  private String token;
  private Long gmt_create;
  private Long gmt_modified;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccount_id() {
    return account_id;
  }

  public void setAccount_id(String account_id) {
    this.account_id = account_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Long getGmt_create() {
    return gmt_create;
  }

  public void setGmt_create(long gmt_create) {
    this.gmt_create = gmt_create;
  }

  public Long getGmt_modified() {
    return gmt_modified;
  }

  public void setGmt_modified(Long gmt_modified) {
    this.gmt_modified = gmt_modified;
  }
}
