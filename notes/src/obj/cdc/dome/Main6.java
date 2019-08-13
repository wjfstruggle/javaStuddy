package obj.cdc.dome;

/**
 * @program: notes
 * @description: super超类
 * @author: wujf
 * @create: 2019-08-13 15:51
 **/
public class Main6 {
  public static void main(String[] args) {
    Cat1 cat = new Cat1("猫", 2, 90);
    System.out.println(cat.getScore());
  }
}

class Cat {
  protected String name;
  protected int age;
  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
class Cat1 extends Cat {
  protected int score;
  public Cat1(String name, int age, int score) {
    super(name, age); // 自动调用父类的构造方法
    this.score = score;
  }
  public int getScore() {
    return this.score;
  }
}
