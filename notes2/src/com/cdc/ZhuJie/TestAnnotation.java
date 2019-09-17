package com.cdc.ZhuJie;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Retention RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
 * RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
 * RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String name();

    int age();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Test {
}