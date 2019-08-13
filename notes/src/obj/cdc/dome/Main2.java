package obj.cdc.dome;

/**
 * @program: notes
 * @description: 构造方法
 * @author: wujf
 * @create: 2019-08-13 12:01
 **/
public class Main2 {
  public static void main(String[] agrs) {
    Dook dook = new Dook("罗威的胜利", 45.7);
    System.out.println(dook.getName()+dook.getAge());
  }
}
class Dook {
  private String name;
  private double age;
  public Dook(String name, double age) {
    this.name = name;
    this.age = age;
  }
  public Dook(String name) {
    this.name = name;
    this.age = 12;
  }
  public Dook() {}
  public String getName() {
    return this.name;
  }
  public double getAge() {
    return this.age;
  }
}
