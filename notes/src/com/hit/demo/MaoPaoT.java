package com.hit.demo;

import java.util.Arrays;

/**
 * @program: notes
 * @description: 冒泡排序
 * @author: wujf
 * @create: 2019-08-13 09:46
 **/
public class MaoPaoT {
    public static void main(String[] args) {
        int[] ns = {23, 32, 13, 34, 3, 45, 31, 9, 18, 5};
        System.out.print(Arrays.toString(ns));
        for (int i = 0; i < ns.length; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                // 降序
                if (ns[j] < ns[j + 1]) {
                    // 交换 ns[j] 和 ns[j+1]
                    int temp = ns[j + 1];
                    ns[j + 1] = ns[j];
                    ns[j] = temp;
                }
            }
        }
        System.out.print(Arrays.toString(ns));
    }
}
