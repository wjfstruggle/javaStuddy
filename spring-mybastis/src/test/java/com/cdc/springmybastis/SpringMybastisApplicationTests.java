package com.cdc.springmybastis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybastisApplicationTests {
  private static SqlSessionFactory sqlSessionFactory;

  @Test
  public void contextLoads() {
  }
  public SqlSession getSqlSession(){
    return sqlSessionFactory.openSession();
  }
}
