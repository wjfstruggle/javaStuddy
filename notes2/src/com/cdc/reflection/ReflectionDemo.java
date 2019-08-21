package com.cdc.reflection;

/**
 * @program: notes2
 * @description: 反射
 * @author: wujf
 * @create: 2019-08-21 17:08
 **/

/**
 * 反射机制，将类的个个组成部分封装为其他对象。
 */
public class ReflectionDemo {
  public static void main(String[] args) throws Exception {
    /**
     * 获取class对象的方式
     * 1、Class.forName(name名). 多用于配置文件，读取文件，加载类
     * 2、通过类名.class 获取 ，用于参数传递
     * 3、通过getClass()在Object中定义， 获取字节码文件
     */
    Class cls = Class.forName("com.cdc.reflection.Person");
    System.out.println(cls);// class com.cdc.reflection.Person
    // 方式二
    Class cls2 = Person.class;
    System.out.println(cls);
    // 方式三
    Person person = new Person();
    Class cls3 = person.getClass();
    System.out.println(cls3);
    System.out.println(cls == cls2);// true
    System.out.println(cls == cls3);// true
  }
}