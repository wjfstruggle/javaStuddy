package com.cdc.Annotation;

public @interface MyAnno1 {
    //  1、基本数据类型
// *      2、String
// *      3、枚举
// *      4、注解
// *      5、以上类型的数组
    String value(); //

    int age(); // 基本类型

    Person person(); // 枚举

    MyAnno2 anno2(); // 注解类型

    String[] str(); // 数组类型
}
