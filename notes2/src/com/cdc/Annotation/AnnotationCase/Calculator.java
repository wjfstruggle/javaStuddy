package com.cdc.Annotation.AnnotationCase;

/**
 * @program: notes2
 * @description: 计算器
 * @author: wujf
 * @create: 2019-08-22 10:56
 **/
public class Calculator {
    @Check
    public void add() {
        System.out.println("1+0=" + (1 + 0));
    }

    @Check
    public void del() {
        System.out.println("1-0=" + (1 - 0));
    }

    @Check
    public void multiply() {
        System.out.println("1*0=" + (1 * 0));
    }

    @Check
    public void except() {
        System.out.println("1/0=" + (1 / 0));
    }
}
