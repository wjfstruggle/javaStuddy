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
    public String animates;
    public String c;
    String d;
    int cat;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("eat 吃饭");
    }

    public void eat(String food) {
        System.out.println("eat 吃饭" + food);
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

    public Person(String name, int age, String animates, String c, String d) {
        this.name = name;
        this.age = age;
        this.animates = animates;
        this.c = c;
        this.d = d;
    }

    public String getAnimates() {
        return animates;
    }

    public void setAnimates(String animates) {
        this.animates = animates;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", animates='" + animates + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
