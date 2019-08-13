package obj.cdc.dome;

/**
 * @program: notes
 * @description: 方法重载
 * @author: wujf
 * @create: 2019-08-13 14:39
 **/
public class Main4 {
  // psvm
  public static void main(String[] args) {
    Hello hello = new Hello();
    hello.setName("猫");
    Hello hong = new Hello();
    hong.setName("狗", 18);
    System.out.println(hello.getName());
    System.out.println(hong.getName()+hong.getAge());
  }
}
class Hello {
  private String name;
  private int age;
  public void hello() {
    System.out.println("hello");
  }
  public void hello(String name) {
    System.out.println("hello"+ name);
  }
  public void hello(String name, int age) {
    if(age < 18) {
      System.out.println("Hi"+name);
    } else {
      System.out.println("hello" + name);
    }
  }
  public String getName() {
    return this.name;
  }
  public int getAge() {
    return this.age;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setName(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
