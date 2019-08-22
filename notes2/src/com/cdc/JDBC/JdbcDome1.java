package com.cdc.JDBC;

import java.sql.*;

/**
 * @program: notes2
 * @description: jdbc基础练习
 * @author: wujf
 * @create: 2019-08-22 15:57
 **/
public class JdbcDome1 {
  // 1、导入jar包
  public static void main(String[] args) throws Exception {
    // 2、注册驱动
    Class.forName("com.mysql.cj.jdbc.Driver");
    // 3、获取数据库连接对象
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false&serverTimezone=UTC", "root", "123456");
    // 4、定义mysql语句
    String sql = "insert into book values('006','JavaScript高级编程','张翰','出版社F','2019-6-30')";
    // 5、获取执行SQL语句对象的Statement
    Statement statement = conn.createStatement();
    // 6、执行SQL语句
    int count = statement.executeUpdate(sql);

    // 处理SQL语句
    System.out.println(count);
    // 8、释放资源
    statement.close();
    conn.close();
  }
}
