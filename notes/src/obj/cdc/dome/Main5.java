package obj.cdc.dome;

/**
 * @program: notes
 * @description: 类的继承
 * @author: wujf
 * @create: 2019-08-13 15:08
 **/
public class Main5 {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        Student student = new Student();
        student.setName("张三");
        student.setAge(23);
        System.out.println(student.getName() + student.getAge());
        System.out.println(student.hello()); // protected使得子类访问父类的字段
    }
}

// 仔细观察，发现Student类包含了Person类已有的字段和方法，只是多出了一个score字段和相应的getScore()、setScore()方法。能不能在Student中不要写重复的代码？
class Person1 {
    protected String name;
    protected int age;

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

//class Student {
//  protected String name;
//  protected int age;
//  protected double score;
//    public String getName() {
//    return this.name;
//  }
//  public void setName(String name) {
//    this.name = name;
//  }
//  public int getAge() {
//    return this.age;
//  }
//  public void setAge(int age) {
//    this.age = age;
//  }
//  public double getScore() {
//      return this.score;
//  }
//  public void setScore(double score) {
//      this.score = score;
//  }
//}
// 继承
class Student extends Person1 {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    protected double score;

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String hello() {
        return "HI" + name;
    }
    // 在OOP的术语中，我们把Person称为超类（super class），父类（parent class），基类（base class），把Student称为子类（subclass），扩展类（extended class）。
}