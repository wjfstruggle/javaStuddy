package obj.cdc.dome;

/**
 * @program: notes
 * @description: class类的使用
 * @author: wujf
 * @create: 2019-08-13 11:11
 **/
public class Main {
  public static void main(String[] args) {
    Person ming = new Person();
    ming.age = 23;
    ming.name = "xiao ming";
    System.out.println(ming.name+" "+ming.age);
  }
}
class Person {
  public String name;
  public int age;
}
