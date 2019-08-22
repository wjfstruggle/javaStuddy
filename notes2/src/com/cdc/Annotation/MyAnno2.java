package com.cdc.Annotation;

public @interface MyAnno2 {
  int age();
  String name() default "张三"; // 属性默认值
}
