package com.hit.demo;

import java.util.Scanner;

/**
 * @program: notes
 * @description: 引用类型的判断
 * @author: wujf
 * @create: 2019-08-12 23:18
 **/
public class ArrayString {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your num: ");
        double n = scanner.nextDouble();
        if (n < 18.5) {
            System.out.println("过轻");
        } else if (n >= 18.5 && n < 25) {
            System.out.println("正常");
        } else if (n >= 25 && n < 28) {
            System.out.println("过重");
        } else {
            System.out.println("肥胖");
        }
        if (s1 != null && s1.equals(s2)) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 !== s2");
        }
        // 判断引用类型是否相等用equals()
    }
}
