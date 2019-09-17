package com.cdc.Annotation;

/**
 * @program: notes2
 * @description: java反射
 * @author: wujf
 * @create: 2019-08-22 09:02
 * <p>
 * 本质： 注解的本质就是一个接口，他继承一个Annotation接口
 * 作用分类
 * 1、编写文档
 * 2、代码分析
 * 3、编译检查
 * 属性：接口中的抽象方法
 * 要求： 属性的返回类型
 * 1、基本数据类型
 * 2、String
 * 3、枚举
 * 4、注解
 * 5、以上类型的数组
 * 要求2：定义了属性使用时给属性赋值
 * 定义属性是，可以使用default进行默认赋值，可以不给注解赋值
 * 如果只有一个属性是，可以直接不写属性，直接给值
 */

/**
 * 本质： 注解的本质就是一个接口，他继承一个Annotation接口
 * 作用分类
 * 1、编写文档
 * 2、代码分析
 * 3、编译检查
 * 属性：接口中的抽象方法
 *    要求： 属性的返回类型
 *      1、基本数据类型
 *      2、String
 *      3、枚举
 *      4、注解
 *      5、以上类型的数组
 *    要求2：定义了属性使用时给属性赋值
 *      定义属性是，可以使用default进行默认赋值，可以不给注解赋值
 *      如果只有一个属性是，可以直接不写属性，直接给值
 */

/**
 * JDk 预定义的一些注解
 * 1、@Override检测该注解的方法是否继承自父类的接口
 * 2、@Deprecated 表示已过时
 * 3、@SuppressWarnings()压制警告 ,一般传递参数 all
 * 自定义注解
 *  格式：
 *    元注解
 *      public @interface 注解名称
 * 在程序使用注解
 *
 * 元注解：描述注解的注解
 * @Target 描述注解能够作用的位置
 * @Retention 描述注解被保留的阶段
 * @Documented 描述注解是否能够被抽取到api文档中
 * @Inherited: 描述注解是否被子类继承
 *
 * 在程序中使用解析注解：
 *    获取注解中定义的属性值
 */

public class AnnoDome1 {
    @Override
    public String toString() {
        return "AnnoDome1{}";
    }

    @Deprecated
    public void show1() {
        // 有缺陷，版本不兼容
    }

    public void show2() {
        // 代替show1方法
    }

    public void demo() {
        show1(); // 使用不了，已过时
        show2();
    }
}
