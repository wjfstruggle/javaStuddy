package com.cdc.reflection;

/**
 * @program: notes2
 * @description: person类
 * @author: wujf
 * @create: 2019-08-21 17:52
 **/
public class Person {
  private String name;
  private int age;
  public Person() {}
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
