package com.cdc.springmybastis;

import com.cdc.springmybastis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @program: spring-mybastis
 * @description: 测试类
 * @author: wujf
 * @create: 2019-09-03 09:28
 **/
public class Test {
  private static SqlSessionFactory sqlSessionFactory;
  private static Reader reader;

  static{
    try{
      reader    = Resources.getResourceAsReader("application.properties");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public static SqlSessionFactory getSession(){
    return sqlSessionFactory;
  }

  public static void main(String[] args) {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      User user = (User) session.selectOne("com.cdc.springmybastis.model.findAll", 1);
      System.out.println(user.getId());
      System.out.println(user.getUsername());
      System.out.println(user.getPassword());
      System.out.println(user.getMoney());
    } finally {
      session.close();
    }
  }
}
