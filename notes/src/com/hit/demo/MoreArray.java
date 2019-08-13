package com.hit.demo;

import java.util.Arrays;

/**
 * @program: notes
 * @description: 多维数组
 * @author: wujf
 * @create: 2019-08-13 10:10
 **/
public class MoreArray {
  public static void main(String[] args) {
    for (String arg : args) {
      System.out.println(arg);
    }
    int[][] ns = {
        {12, 1, 2, 3},
        {34, 3, 5, 4},
        {12, 45, 6, 0}
    };
    int[] arr0 = ns[0];
//    System.out.print(Arrays.toString(arr0));
//    System.out.print(Arrays.deepToString(ns)); // 打印二维数组
    int[][] scores = {
        {82, 90, 91},
        {68, 72, 64},
        {95, 91, 89},
        {67, 52, 60},
        {79, 81, 85},
    };
    double average = 0;
    int sum = 0;
    int cnt = 0;
//    for (int i = 0; i < scores.length; i++) {
////      for (int j = 0; j < scores[i].length; j++) {
////        sum += scores[i][j];
////        cnt ++;
////      }
////    }
    for (int[] arr: scores) {
      for (int n : arr) {
        sum += n;
        cnt ++;
      }
    }
    average = (double)sum / cnt;
    System.out.printf("%.2f",average);
  }
}
