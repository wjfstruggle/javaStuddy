package com.cdc.ZhuJie;

/**
 * @program: notes2
 * @description: 注解，Java 注解用于为 Java 代码提供元数据。作为元数据，注解不直接影响你的代码执行，但也有一些类型的注解实际上可以用于这一目的。Java 注解是从 Java5 开始添加到 Java 的。
 * @author: wujf
 * @create: 2019-08-21 10:55
 **/

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 常用注解
 * 元注解：@Retention，@Documented、@Target、@Inherited、@Repeatable 5 种。
 *
 * @Retention Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
 * @Documented 它的作用是能够将注解中的元素包含到 Javadoc 中去。
 * @Target
 * @Deprecated 标记过时的元素
 * @SuppressWarnings 警告的意思
 */
//  TestAnnotation 这个注解中拥有 age 和 name 两个属性。在使用的时候，我们应该给它们进行赋值。
@TestAnnotation(age = 3, name = "hello")
public class Main {
    @Check(value = "hi")
    int f;

    @Perform
    public void testMethod() {
    }

    public static void main(String[] args) throws Exception {
        Hero hero = new Hero();
        hero.say(); // 过时了
        hero.speak();
        // 通过反射调用属性的方法
        boolean hasAnnotation = Main.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation = Main.class.getAnnotation(TestAnnotation.class);
            System.out.println("age:" + testAnnotation.age()); // 3
            System.out.println("name:" + testAnnotation.name()); // hello
        }
        try {
            Field f = Main.class.getDeclaredField("f");
            f.setAccessible(true);
            Check check = f.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check.value" + check.value());
            }
            Method testMethod = Main.class.getDeclaredMethod("testMethod");
            if (testMethod != null) {
                Annotation[] ans = testMethod.getAnnotations();
                for (int i = 0; i < ans.length; i++) {
                    System.out.println(ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("deprecation")
    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }
}

class Hero {
    @Deprecated // 标记过时的元素
    public void say() {
        System.out.println("Nothing has to say");
    }

    public void speak() {
        System.out.println("i am have dream");
    }

    @SuppressWarnings("deprecation")
    public void test1() {
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }
}
/***
 * @Target 目标注解
 * ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 * ElementType.CONSTRUCTOR 可以给构造方法进行注解
 * ElementType.FIELD 可以给属性进行注解
 * ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 * ElementType.METHOD 可以给方法进行注解
 * ElementType.PACKAGE 可以给一个包进行注解
 * ElementType.PARAMETER 可以给一个方法内的参数进行注解
 * ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 */