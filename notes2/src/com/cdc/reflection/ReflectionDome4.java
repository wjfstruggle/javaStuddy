package com.cdc.reflection;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionDome4 {
    /**
     * 可以创建任意对象，执行任意方法,前提不能改变该类的方法
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        /**
         * 1、加载配置文件
         */
        // 创建对象
        Properties pro = new Properties();
        // 加载配置文件
        ClassLoader classLoader = ReflectionDome4.class.getClassLoader();
        InputStream ic = classLoader.getResourceAsStream("pro.properties");
        pro.load(ic);
        // 配置文件中定义数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        // 加载该类进内存
        Class aClass = Class.forName(className);
        // 创建对象
        Object o = aClass.newInstance();
        // 获取方法对象
        Method method = aClass.getMethod(methodName);
        // 执行方法
        method.invoke(o);
    }
}
