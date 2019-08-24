package com.cdc.JDBC;

import com.cdc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @program: notes2
 * @description: 登录
 * @author: wujf
 * @create: 2019-08-24 10:03
 **/
public class JDBCDome9 {
  /**
   * 需求： 通过键盘输入用户名和密码
   *       判断用户是否登录成功
   */
  public static void main(String[] args) {
    // 键盘录入
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入用户名：");
    String username = scanner.nextLine();
    System.out.println("请输入密码：");
    String password = scanner.nextLine();
    // 调用方法
    // 判断结果
    boolean login = new JDBCDome9().login(username,password);
    if (login) {
      // 登录成功
      System.out.println("登录成功");
    } else {
      System.out.println("登录失败");
    }
  }
  public boolean login(String username, String password) {
    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    if (username == null || password == null) {
      return false;
    }
    try {
      conn = JDBCUtils.getConnection();
      // 定义SQL语句
      String sql = "select * from user where username='"+username+"' and password='"+password+"'";
      // 获取SQL对象
      statement = conn.createStatement();
      // 执行SQL语句
      rs = statement.executeQuery(sql);
      return rs.next(); // 如果有下一行，则返回true
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(rs, statement, conn);
    }
    return false;
  }
}
