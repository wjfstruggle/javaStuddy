package com.cdc.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: notes2
 * @description: c3p0连接池
 * @author: wujf
 * @create: 2019-08-26 10:53
 **/
public class C3P0Dome1 {
  public static void main(String[] args) throws SQLException {
    // 创建数据库连接池对象
    DataSource ds = new ComboPooledDataSource();
    // 获取连接对象
    Connection conn = ds.getConnection();
    System.out.println(conn);
  }
}
