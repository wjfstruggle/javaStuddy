package com.cdc.JDBC;

import com.cdc.JDBCExercise.Book;
import com.cdc.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: notes2
 * @description: Java数据库操作
 * @author: wujf
 * @create: 2019-08-23 11:42
 **/
public class JDBCDome4 {
    public static void main(String[] args) {
        List<Book> list = new JDBCDome4().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    // 查询Book所有的对象
    public List<Book> findAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Book> list = null;
        try {
//     Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接对象
//     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false&serverTimezone=UTC", "root", "123456");
            conn = JDBCUtils.getConnection();
            String sql = "select * from book";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            Book book = null;
            while (resultSet.next()) {
                int bno = resultSet.getInt("bno");
                String bname = resultSet.getString("bname");
                String author = resultSet.getString("author");
                String publish = resultSet.getString("publish");
                Date pubdate = resultSet.getDate("pubdate");
                // 创建Book对象, 并赋值
                book = new Book();
                book.setBno(bno);
                book.setBname(bname);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPubdate(pubdate);
                list = new ArrayList<Book>();
                // 装载集合
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 工具类封装了异常的方法
            JDBCUtils.close(resultSet, statement, conn);
        }
        return list;
    }
}
