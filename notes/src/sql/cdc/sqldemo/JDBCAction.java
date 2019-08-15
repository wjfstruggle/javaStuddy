package sql.cdc.sqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: notes
 * @description: 数据库基本操作
 * @author: wujf
 * @create: 2019-08-15 15:30
 **/
public class JDBCAction {
  public static void main(String[] args) {
    query();
    insert();
    finAll();
  }
  static Connection conn; // 创建静态全局变量
  static Statement statement;
  // 连接数据库函数
  public static Connection getConnection() {
    Connection con = null;// 创建用于连接数据库的Connection连接对象
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/user?useSSL=FALSE&serverTimezone=UTC";
    String user = "root";
    String password = "123456";
    try {
      Class.forName(driver); // 加载mysql数据驱动
      con = DriverManager.getConnection(url, user, password);// 创建数据连接
      if (con != null) {
        System.out.println("数据库连接成功");
      }
    } catch (Exception e) {
      System.out.println("数据库连接失败"+e.getMessage());
    }
    return con;// 返回数据库建立的连接
  }
  // 基本查询
  public static boolean query() {
    conn = getConnection(); // 获取连接
    try {
      String sql = "select * from cdc_test";
      statement = (Statement) conn.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      String name;
      while (resultSet.next()) { // 判断是否还有下一个数据
        name = resultSet.getString("username");
        System.out.println(name);
//        return true;
      }
      conn.close(); // 关闭数据库
    } catch (Exception e) {
      System.out.println("查询数据库失败");
    }
    return false;
  }
  // 插入数据Insert
  public static void insert(Test t) {
    conn = getConnection();// 获取连接
    try {
      String sql = "insert into cdc_test (username,password,score) VALUE ("+t.getUsername()+","+ t.getPassword()+","+t.getScore()+")";
      statement = (Statement) conn.createStatement();
      int count = statement.executeUpdate(sql);
      if(count !=0) {
        System.out.println("插入成功");
        System.out.println("向数据库插入"+count+"数据");
      }
      conn.close(); // 关闭数据库
    } catch (Exception e) {
      System.out.println("插入数据失败");
    }
  }
  // 查询所有
  public static List<Test> finAll() {
    conn = getConnection();// 获取连接
    List<Test> ts = new ArrayList<Tset>();
    try {
      String sql = "select * from cdc_test";
      statement = (Statement) conn.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String score = resultSet.getString("score");
        Test t = new Test();
        t.setUsername(username);
        t.setPassword(password);
        t.setScore(score);
      }
      conn.close();
    } catch (Exception e) {
      System.out.println("数据查询失败 findAll");
    }
    return ts;
  }
}