package com.cdc.reflection;

/**
 * @program: notes2
 * @description: java反射
 * @author: wujf
 * @create: 2019-08-21 19:31
 **/

import java.lang.reflect.Field;

/**
 * @获取成员变量 Field getField(String name) // 只能获取public修饰的成员变量
 * Field[] getFields() // 只能获取public修饰的成员变量
 * Field getDeclaredField(String name)
 * Field[] getDeclaredFields() // 获取所有的成员变量，无论用什么修饰符
 * @获取方法 Method getMethod(String name, 类<?>... parameterTypes)
 * Method[] getMethods()
 * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 * Method[] getDeclaredMethods()
 * @获取构造方法 Constructor<T> getConstructor(类<?>... parameterTypes)
 * Constructor<?>[] getConstructors()
 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 * Constructor<?>[] getDeclaredConstructors()
 */
public class ReflectionDemo1 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
//    Field getField(String name) // 只能获取public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------------");
        Field field = personClass.getField("animates");
        // get(Object obj)
        Person person = new Person();
        Object value = field.get(person); // 获取值
        System.out.println(value); // null
        field.set(person, "张三");// 设置值
        System.out.println(person); // Person{name='null', age=0, animates='张三', c='null', d='null'}
        System.out.println("---------------------------");
        // Field getDeclaredField(String name)
        // * Field[] getDeclaredFields() // 获取所有的成员变量，无论用什么修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field df : declaredFields) {
            System.out.println(df);
        }
        Field declaredField = personClass.getDeclaredField("animates");
        System.out.println(declaredField);
        declaredField.setAccessible(true); // 暴力反射
        Object value2 = declaredField.get(person);
        System.out.println(value2); // 张三
        declaredField.set(person, "李四");
        System.out.println(person); // Person{name='null', age=0, animates='李四', c='null', d='null'}
    }
}
