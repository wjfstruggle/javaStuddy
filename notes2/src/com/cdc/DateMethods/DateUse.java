package com.cdc.DateMethods;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @program: notes2
 * @description: 日期使用方法
 * @author: wujf
 * @create: 2019-08-19 16:40
 **/
public class DateUse {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(ft.format(date));
    }
}
