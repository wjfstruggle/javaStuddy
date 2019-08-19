package com.cdc.ArrayMethods;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    // 根据分割符拼接数组元素（去掉最后一个分隔符）
    String j = StringUtils.join(new String[] {"a","b","c","d"}, "*");
    System.out.println(j);// a*b*c*d
    // ArrayList转数组
    String[] hArray = { "a", "b", "c", "d", "e" };
    ArrayList<String> iArray = new ArrayList<String>(Arrays.asList(hArray));
    String[] jArray = new String[iArray.size()];
    iArray.toArray(hArray);
    for (String s: hArray) {
      System.out.println(s);
    }
    // 数组转set
    Set<String> kArray = new HashSet<>(Arrays.asList(hArray));
    System.out.println(kArray);
    // 翻转数组
    ArrayUtils.reverse(hArray);
    System.out.println(Arrays.toString(hArray)); // [e, d, c, b, a]
    // 删除数组
//    String[] lArray = ArrayUtils.removeElement(hArray, "a");
    String[] lArray = ArrayUtils.removeElements(hArray, "a","b"); // 删除多个
    System.out.println(Arrays.toString(lArray));
  }
}
