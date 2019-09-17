package com.cdc.reflection;

import java.lang.reflect.Method;

/**
 * @program: notes2
 * @description: java反射
 * @author: wujf
 * @create: 2019-08-21 20:15
 **/
public class ReflectionDemo3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        // Object invoke(Object obj, Object... args)  执行方法
        Method eat_mthod = personClass.getMethod("eat");
        Person person = new Person();
        eat_mthod.invoke(person); // eat 吃饭 执行方法
        Method eat_mthod2 = personClass.getMethod("eat", String.class);
        eat_mthod2.invoke(person, "菜"); // eat 吃饭菜

        Method[] eat_method3 = personClass.getMethods();
        for (Method method : eat_method3) {
            String name = method.getName(); // 获取方法名
            System.out.println(name);
        }
    }
}
