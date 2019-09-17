package com.hit.demo;

import java.util.Arrays;

/**
 * @program: notes
 * @description: 数组的遍历
 * @author: wujf
 * @create: 2019-08-13 09:01
 **/
public class ArrayT {
    public static void main(String[] args) {
        int[] ns = {1, 33, 34, 56, 15};
        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
        // forEach 循环
        for (int n : ns) {
            System.out.println(n);
        }
        System.out.print(Arrays.toString(ns));
        // 倒叙打印数组
        int[] dd = {1, 33, 34, 56, 15};
        for (int j = dd.length - 1; j >= 0; j--) {
            int s = dd[j];
            System.out.print(s);
        }
    }
}
