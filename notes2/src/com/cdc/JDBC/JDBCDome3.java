package com.cdc.JDBC;

import java.sql.*;

/**
 * @program: notes2
 * @description: java数据库操作
 * @author: wujf
 * @create: 2019-08-23 09:19
 **/

// 添加一条记录
public class JDBCDome3 {
  public static void main(String[] args) {
    Connection coon = null;
    Statement statement = null;
    ResultSet rs = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.cj.jdbc.Driver");
      // 获取连接对象
      coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false&serverTimezone=UTC", "root", "123456");
      // 定义SQL语句
      String sql = "select * from book";
      statement = coon.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        Integer bno = rs.getInt(1);
        String bname = rs.getString("bname");
        String author = rs.getString("author");
        String publish = rs.getString("publish");
        Date pubdate = rs.getDate("pubdate");
        System.out.println(bno + bname + author + publish + pubdate);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 释放资源
      if(rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(coon != null) {
        try {
          coon.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
