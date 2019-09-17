package com.cdc.ObjectSt;

import java.lang.reflect.Field;

/**
 * @program: notes2
 * @description: 方法重载
 * @author: wujf
 * @create: 2019-08-21 09:10
 **/
public class OverloadMethods {
    public static void main(String[] args) throws Exception {
        Person person = new Person("小明");
        // 访问字段
        Class c = person.getClass(); // 获取class的一切信息
        Class p = Student.class; // 调用方法
        System.out.println(p.getMethod("getScore", Double.class));
        Field f = c.getDeclaredField("name"); // 获取字段name
        f.setAccessible(true); // 允许访问
        f.set(person, "小红"); // 设置字段值
        System.out.println(person.getName());
    }
}

class Person {
    private String name;
    private int age;

    // 这种方法名相同，但各自的参数不同，称为方法重载（Overload）。
    public Person() {
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        System.out.println(name);
    }
}
// 继承,通过继承，只需编写额外的功能，不需要重复代码。

/**
 * 继承有个特点，就是子类无法访问父类的private字段或者private方法。例如，Student类就无法访问Person类的name和age字段：
 * 只需将private改成protected
 */
class Student extends Person {
    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
// 调用方法
