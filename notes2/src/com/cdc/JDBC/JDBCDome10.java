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
public class JDBCDome10 {
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
    boolean login = new JDBCDome10().login2(username,password);
    if (login) {
      // 登录成功
      System.out.println("登录成功");
    } else {
      System.out.println("登录失败");
    }
  }
  public boolean login2(String username, String password) {
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    if (username == null || password == null) {
      return false;
    }
    try {
      conn = JDBCUtils.getConnection();
      // 定义SQL语句
      String sql = "select * from user where username= ? and password= ?";
      // 获取SQL对象
      psmt = conn.prepareStatement(sql);
      // 执行SQL语句,不需要传参数
      psmt.setString(1, username);
      psmt.setString(2, password);
      rs = psmt.executeQuery();
      return rs.next(); // 如果有下一行，则返回true
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(rs, psmt, conn);
    }
    return false;
  }
}
