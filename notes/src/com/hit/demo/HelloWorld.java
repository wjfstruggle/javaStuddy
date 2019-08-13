package com.hit.demo;
import java.util.Scanner;
/**
 * @program: notes
 * @description:java基础语法
 * @author: wujf
 * @create: 2019-08-12 11:11
 **/
public class HelloWorld {
    public static void main(String[] args) {
        int[] ns = {23,23,34,56};
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        String name = scanner.nextLine();  // 读取一行输入并读取字符串
        int age = scanner.nextInt(); //
        System.out.print("input your lastScore：");
        int lastScore = scanner.nextInt(); // 上一次分数
        System.out.print("input your currentScore：");
        int currenScore = scanner.nextInt();// 本次分数
        double n = (currenScore - lastScore)/(double)lastScore;
        System.out.printf("成绩提高了%.2f%%",n*100);
        System.out.println("------------------------");
        System.out.printf("%d, %s",age ,name);
//      字符串数组
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println("HelloWorld");
        System.out.println(23);
        System.out.println(ns.length);
        System.out.printf("%s\n",s);
        System.out.println(23);
    }
}
