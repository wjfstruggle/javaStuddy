package com.cdc.JavaMethods;

/**
 * @program: notes2
 * @description: java方法
 * @author: wujf
 * @create: 2019-08-19 17:02
 **/
/**
* finalize() 方法
 * Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。
 * 例如，你可以使用 finalize() 来确保一个对象打开的文件被关闭了。
 * 在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。
 * finalize() 一般格式是：
*/
public class Methods {
  public static void main(String[] args) {
    Cark cark1 = new Cark(1);
    Cark cark2 = new Cark(2);
    Cark cark3 = new Cark(3);
    cark2 = cark3 = null;
    System.gc();
    PrintMax(1,3,4,6,8,9,23);
    PrintMax(new double[]{3,45,53,2});
  }
  // 可变参数
  public static void PrintMax(double... numbers) {
    if(numbers.length == 0) {
      System.out.println("number is empty");
      return;
    }
    double result = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > result) {
        result = numbers[i];
      }
    }
    System.out.println("The max value is"+ result);
  }
}
class Cark extends Object {
  private int id;
  public Cark(int id) {
    this.id = id;
    System.out.println("Cake Object " + id + "is created");
  }
  protected void finalize () throws java.lang.Throwable{
    super.finalize();
    System.out.println("Cake Object " + id + "is disposed");
    // 在这里终结代码
  }
}