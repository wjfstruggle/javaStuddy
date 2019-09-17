package com.cdc.Annotation;

import java.lang.reflect.Method;

/**
 * 可以创建任意对象，执行任意方法,前提不能改变该类的方法
 *
 * @param args
 */
@Pro(className = "com.cdc.Annotation.Analysis1", methodName = "show1")
public class ReflectionDome4 {
    //  之前使用配置文件，现在使用注解来修改反射案例
    public static void main(String[] args) throws Exception {
        // 1、解析注释
        // 1.1获取该类的字节码文件对象
        Class<ReflectionDome4> reflectionDome4Class = ReflectionDome4.class;
        // 获取上边的注解对象
        Pro anno = reflectionDome4Class.getAnnotation(Pro.class);
        // 调用注解对象定义的抽象方法，获取返回值
        String className = anno.className();
        String methodName = anno.methodName();
        System.out.println(className);// package com.cdc.Annotation.Analysis1

        System.out.println(methodName); // show1

        // 加进内存
        Class aClass = Class.forName(className);
        // 创建对象
        Object o = aClass.newInstance();
        // 获取方法对象
        Method method = aClass.getMethod(methodName);
        // 执行方法
        method.invoke(o);
    }
}

