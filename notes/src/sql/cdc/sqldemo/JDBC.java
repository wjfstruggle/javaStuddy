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
      connection.close(); // 关闭数据库
      Statement statement = connection.createStatement();
//      String sql = "select * from cdc_test"; // 我的表格
//      String sql = "select * from cdc_test where score >=90"; // 我的表格，条件限定查询
//      String sql = "select * from cdc_test where score >=90 and username = 'cdc001'"; // 我的表格，条件限定查询
//      String sql = "select * from cdc_test order by score"; // 我的表格，成绩升序
//      String sql = "select * from cdc_test order by score DESC "; // 我的表格，成绩倒序
      String insert = "INSERT INTO cdc_test (username,password, score) VALUES('cdc006',23344, 83)";
      String inserts = "INSERT INTO cdc_test (username,password, score) VALUES('cdc006',23344, 83)INSERT INTO cdc_test (username,password, score) VALUES('cdc006',23344, 83),('cdc007',25344, 87)";// 插入多条
//      String delects = "DELETE from cdc_test where id = 8";// 插入多条
//      ResultSet resultSet = statement.executeQuery(sql);
//      int count = statement.executeUpdate(inserts);// 执行插入操作的sql语句，并返回插入数据的个数
      String sum = "SELECT SUM(score) total from cdc_test";
      int n = statement.executeUpdate(sum);// 执行插入操作的sql语句，并返回插入数据的个数
      System.out.println("总成绩为："+n);
      String name;
      Double score;
//      while (resultSet.next()) {
//        name = resultSet.getString("username");
//        score = resultSet.getDouble("score");
//        System.out.println("名字"+name+"分数"+score);
//      }
    } catch (ClassNotFoundException e) {
      System.out.println("数据库没有连接成功"+e);
    } catch (SQLException e) {
      System.out.println("数据库连接失败"+e);
    }
  }
}

