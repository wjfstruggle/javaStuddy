package obj.cdc.dome;

/**
 * @program: notes
 * @description: 构造方法的使用, 调用其他构造方法，代码复用
 * @author: wujf
 * @create: 2019-08-13 14:27
 **/
public class Main3 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.getName() + dog.getAge());
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this(name, 18); //调用另一个构造方法Dog(String, int)
    }

    public Dog() {
        this("秋田犬"); // 调用另一个构造方法Dog(String)
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
