package obj.cdc.dome;

/**
 * @program: notes
 * @description: 类的继承
 * @author: wujf
 * @create: 2019-08-13 15:08
 **/
public class Main5 {
  public static void main(String[] args) {

  }
}
// 仔细观察，发现Student类包含了Person类已有的字段和方法，只是多出了一个score字段和相应的getScore()、setScore()方法。能不能在Student中不要写重复的代码？
class Person1 {
  private String name;
  private int age;
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return this.age;
  }
  public void setAge(int age) {
    this.age = age;
  }
}
class Student {
  private String name;
  private int age;
  private double score;
    public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return this.age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public double getScore() {
      return this.score;
  }
  public void setScore(double score) {
      this.score = score;
  }
}