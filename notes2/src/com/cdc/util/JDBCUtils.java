package com.cdc.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @program: notes2
 * @description: 工具类
 * @author: wujf
 * @create: 2019-08-23 16:52
 **/

public class JDBCUtils {
    public static String url;
    public static String user;
    public static String password;
    public static String driver;

    // 静态代码块，用于文件的读取
    static {
        // 1、创建Properties集合类
        Properties pro = new Properties();
        // 加载文件
        try {
            // 获取src文件下面的路径： 使用类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
//      System.out.println(path);
            pro.load(new FileReader(path));
            // 获取属性，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接方法
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // 处理异常方法

    public static void close(ResultSet resultSet, Statement statement, Connection conn) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
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
