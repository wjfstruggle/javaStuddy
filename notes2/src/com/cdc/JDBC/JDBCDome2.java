package com.cdc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: notes2
 * @description: java数据库操作
 * @author: wujf
 * @create: 2019-08-23 09:19
 **/

// 添加一条记录
public class JDBCDome2 {
    public static void main(String[] args) {
        Connection coon = null;
        Statement statement = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接对象
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false&serverTimezone=UTC", "root", "123456");
            // 定义SQL语句
            // 添加一条记录
//      String sql = "insert into book values ('007','技术算计网络','王五','出版社G','2019-7-10')";
            // 更新一条记录
            String sqlUpdate = "update book set bname='智能网关' where bno = 007";
            // 删除一条记录
            String sqlDelete = " delete from book where bno = 007";
            // 获取执行SQL语句对象的Statement
            statement = coon.createStatement();
//      int count = statement.executeUpdate(sql);
//      int count1 = statement.executeUpdate(sqlUpdate);
            int count2 = statement.executeUpdate(sqlDelete);
            if (count2 > 0) {
                System.out.println("删除成功" + count2);
            } else {
                System.out.println("删除失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (coon != null) {
                try {
                    coon.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
