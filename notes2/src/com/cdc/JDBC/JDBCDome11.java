package com.cdc.JDBC;

import com.cdc.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @program: notes2
 * @description: 登录，PreparedStatement的用法
 * @author: wujf
 * @create: 2019-08-24 10:03
 **/
public class JDBCDome11 {
  /**
   * 需求： 事务回滚案例
   *
   */
  public static void main(String[] args) throws SQLException {
    Connection conn = null;
    PreparedStatement pste1 = null;
    PreparedStatement pste2 = null;
    try {
      // 获取连接
      conn = JDBCUtils.getConnection();
      // 开启事务
      conn.setAutoCommit(false);
      // 定义SQL语句
      String sql1 = "update user set money = money - ? where id=?";
      String sql2 = "update user set money = money + ? where id=?";
      pste1 = conn.prepareStatement(sql1);
      pste2 = conn.prepareStatement(sql2);
      pste1.setDouble(1, 30);
      pste1.setInt(2, 1);

      pste2.setDouble(1, 30);
      pste2.setInt(2, 2);

      pste1.executeUpdate();

      pste2.executeUpdate();
      // 提交事务
      conn.commit();
    } catch (SQLException e) {
      // 事务回滚操作
      conn.rollback();
      e.printStackTrace();
    } finally {
      if (pste2 != null) {
        try {
          pste2.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (pste1 != null) {
        try {
          pste1.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
  }
