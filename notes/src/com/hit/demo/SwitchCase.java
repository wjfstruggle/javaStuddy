package com.hit.demo;

/**
 * @program: notes
 * @description: switch语句用法
 * @author: wujf
 * @create: 2019-08-13 08:45
 **/
public class SwitchCase {
    public static void main(String[] agrs) {
        int options = 4;
        switch (options) {
            case 1:
                System.out.println("Selected 1");
               break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            default:
                System.out.println("Selected default");
                break;
        }
    }
}
