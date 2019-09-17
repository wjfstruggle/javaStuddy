package com.cdc.reflection;

/**
 * @program: notes2
 * @description: java反射
 * @author: wujf
 * @create: 2019-08-21 19:31
 **/

import java.lang.reflect.Constructor;
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
public class ReflectionDemo2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        // 创建对象
//    T newInstance(Object... initargs)
        Object object = constructor.newInstance("王五", 34);
        System.out.println(object); // Person{name='王五', age=34, animates='null', c='null', d='null'}
    }
}
