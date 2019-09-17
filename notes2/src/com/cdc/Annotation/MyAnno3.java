package com.cdc.Annotation;

import java.lang.annotation.*;

/**
 * 元注解：描述注解的注解
 *
 * @Target 描述注解能够作用的位置
 * ElementType 取值
 * TYPE：作用于类上
 * METHOD：作用于方法上
 * FIELD：作用于成员变量上
 * @Retention 描述注解被保留的阶段
 * RetentionPolicy取值
 * SOURCE
 * RUNTIME 当前被描述的注解
 * CLASS
 * @Documented 描述注解是否能够被抽取到api文档中
 * @Inherited: 描述注解是否被子类继承
 */
@Target(value = {ElementType.TYPE}) // 只能作用在类上
@Retention(RetentionPolicy.RUNTIME) // 一般去RUNTIME
@Inherited
public @interface MyAnno3 {

}
