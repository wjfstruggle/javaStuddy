package sql.cdc.sqldemo;

import java.sql.*;

/**
 * @program: notes
 * @description: 数据库连接
 * @author: wujf
 * @create: 2019-08-15 09:32
 **/
public class JDBC {
  public static void main(String[] args) {
    Connection connection = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    // 我的数据库
    String url = "jdbc:mysql://localhost:3306/user?useSSL=FALSE&serverTimezone=UTC";
    String user = "root";
    String password = "123456";
    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, user, password);
      // 是否连接
      if(connection != null) {
        System.out.println("数据库连接成功");
      }
      Statement statement = connection.createStatement();
      String sql = "select * from cdc_test"; // 我的表格
      ResultSet resultSet = statement.executeQuery(sql);
      String name;
      while (resultSet.next()) {
        name = resultSet.getString("username");
        System.out.println(name);
      }
    } catch (ClassNotFoundException e) {
      System.out.println("数据库没有连接成功"+e);
    } catch (SQLException e) {
      System.out.println("数据库连接失败"+e);
    }
  }
}

