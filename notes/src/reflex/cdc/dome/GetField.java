package reflex.cdc.dome;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @program: notes
 * @description: 访问字段
 * @author: wujf
 * @create: 2019-08-14 17:28
 **/

public class GetField {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public字段“score”
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("name"));
        System.out.println(stdClass.getDeclaredField("grade"));
        Field f = String.class.getDeclaredField("value");
        System.out.println(f.getName() + f.getType());
    }
}

class Person {
    public String name;
}

class Student extends Person {
    public int score;
    private int grade;
}