package com.cdc.Annotation.AnnotationCase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @program: notes2
 * @description: 计算的检查
 * @author: wujf
 * @create: 2019-08-22 10:59
 **/
public class TestCheck {
  public static void main(String[] args) throws IOException{
    // 创建计算机对象
    Calculator calculator = new Calculator();
    // 获取字节码文件对象
    Class aClass = calculator.getClass();
    // 获取所有方法
    Method[] methods = aClass.getDeclaredMethods();
    int number = 0; // 异常次数
    BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt")); // 读入到文件当中去
    // 判断方法是是否有注解
    for (Method method : methods) {
      if (method.isAnnotationPresent(Check.class)) {
        try {
          // 有，执行
          method.invoke(calculator);
        } catch (Exception e) {
          // 捕获异常，记录到文件中
          number ++;
          e.getMessage();
          bw.write(method.getName() + "出现异常了");
          bw.newLine();
          bw.write("异常的名称"+e.getCause().getClass().getSimpleName());
          bw.newLine();
          bw.write("异常的原因" + e.getCause().getMessage());
          bw.newLine();
        }
      }
    }
    bw.write("出现了多少"+number+"次异常");
    bw.flush();
    bw.close();
  }

}
