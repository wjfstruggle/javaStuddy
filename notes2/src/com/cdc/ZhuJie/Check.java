package com.cdc.ZhuJie;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @program: notes2
 * @description: 值得获取
 * @author: wujf
 * @create: 2019-08-21 15:28
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String value();
}
