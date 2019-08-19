package com.cdc.ArrayMethods;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: notes2
 * @description: 数组方法的使用
 * @author: wujf
 * @create: 2019-08-19 15:12
 **/
public class ArrayMethodUse {
  public static void main(String[] args) {
    // 声明数组：
    String[] aArray = new String[5];
    String[] bArray = {"a", "b","c","d"};
    String[] cArray = new String[] {"a", "b","c","d"};
    // 打印数组
    System.out.println(aArray+ Arrays.toString(bArray) + Arrays.toString(cArray));
    // 根据数组创建ArrayList
    String[] StringArray = {"a", "b","c","d"};
    ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(StringArray));
    ArrayList<String> arrayList1 = new ArrayList<>();
    System.out.println(arrayList);
    // 判断数组内部是否包含某个值
    String[] dArray = {"a", "b","c","d","e","f","g"};
    boolean flag = Arrays.toString(dArray).contains("a");
    System.out.println(flag); // true
    // 连接两个数组
    int[] eArray = { 1, 2, 3, 4, 5 };
    int[] fArray = { 6, 7, 8, 9, 10 };
    int[] gArray = ArrayUtils.addAll(eArray, fArray);
    System.out.println(Arrays.toString(gArray));
  }
}
