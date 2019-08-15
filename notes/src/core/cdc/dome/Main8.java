package core.cdc.dome;

/**
 * @program: notes
 * @description: StringBuilder,Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象：
 * @author: wujf
 * @create: 2019-08-14 11:12
 **/
public class Main8 {
  public static void main(String[] args) {
    // StringBuilder
    StringBuilder sb = new StringBuilder(1024); // 分配缓冲区
    sb.append("Mr ").append("Bon").append("!").insert(0, "hello, ");
    // insert 在字符串插入字符串 index:起始位置后面 str：要插入的字符串
    System.out.println(sb);
    Adder adder = new Adder();
    adder.add(3).add(5).inc().add(10);
    System.out.println(adder.value());
  }
}
// 实现一个不断增加的计数器
class Adder {
  protected int sum = 0;
  public Adder add(int n) {
    sum += n;
    return this;
  }
  public Adder inc() {
    sum++;
    return this;
  }
  public int value() {
    return this.sum;
  }
}
