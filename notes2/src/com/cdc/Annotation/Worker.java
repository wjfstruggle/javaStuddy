package com.cdc.Annotation;

/**
 * @program: notes2
 * @description: 注解的属性赋值
 * @author: wujf
 * @create: 2019-08-22 09:34
 **/
@MyAnno2(age = 23, name = "张三")
@MyAnno1(value = "29", age = 23, person = Person.P1, anno2 = @MyAnno2(age = 23, name = "张三"), str = {"abb", "er"})
@MyAnno3
public class Worker {
    //  @MyAnno3 报错，不能作用在方法上
    public void show() {
    }
}
