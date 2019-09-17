package core.cdc.dome;

import java.util.Arrays;

/**
 * @program: notes
 * @description: 字符串和编码
 * @author: wujf
 * @create: 2019-08-14 10:48
 **/
public class Main7 {
    public static void main(String[] args) {
        String s = "hello";
        String s2 = "Hello";
        System.out.println(s.equals(s2)); // equals比较字符串是否相同 false
        System.out.println(s.equalsIgnoreCase(s2)); // equalsIgnoreCase()忽略大小写 true
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);
        // 分割字符串
        String s1 = "h,e,l,l,o";
        String[] arr = s1.split("//,");
        System.out.println(Arrays.toString(arr)); // [h,e,l,l,o] 分割成数组
        // 拼接字符串
        String[] arr2 = {"a", "b", "c", "d"};
        String arr3 = String.join("*", arr2); // 拼接成数组
        System.out.println(arr3);
        char[] cs = "HELLO".toCharArray();
        System.out.println(cs);
    }
    // equalsIgnoreCase()忽略大小写
}
