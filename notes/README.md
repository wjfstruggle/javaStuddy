#### idea为Project的配置文件目录；
#### .iml为Module的配置文件。

- project和module的区别

- class是java用来定义类的，定义类的格式class 类名
注意类名需要开头需要大写
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }
}
```
### 关键字：
- 关键字都是小写

### 标识符
- 标识符：就是给类,接口,方法,变量等起名字时使用的字符序列(字符串)
```java
/*
	标识符：就是给类,接口,方法,变量等起名字时使用的字符序列(字符串)
	组成规则：
		A:英文字母大小写
		B:数字
		C:_和$
	注意事项：
		A:不能以数字开头
		B:不能是Java中的关键字
		C:区分大小写
			Student,student 这是两个名称
	常见的命名规则：见名知意
		A:包 其实就是文件夹,用于解决相同类名问题
			全部小写
			单级：com
			多级：cn.itcast
		B:类或者接口
			一个单词：首字母大写
				Student,Person,Teacher
			多个单词：每个单词的首字母大写
				HelloWorld,MyName,NameDemo
		C:方法或者变量
			一个单词：全部小写
				name,age,show()
			多个单词：从第二个单词开始，每个单词首字母大写
				myName,showAllStudentNames()
		D:常量
			一个单词：全部大写
				AGE
			多个单词：每个单词都大写，用_连接
				STUDENT_MAX_AGE
*/
```
### 常量
- 字符串常量、整数常量、小数常量、字符常量、布尔常量

### 变量：
- 基本类型的变量和引用类型的变量
- 基本数据类型
> 整数类型 byte(1字节)、short(2字节)、int(4字节)、long(8字节)

> 浮点类型：float(4字节)、double(8字节)

> 字符类型：char(2字节)

> 布尔类 型：Boolean

### 数组的定义
- 声明数组 数据类型[] = new 数据类型[]
- 简写 数据类型[] 变量名 = {数据}

### 输入和输出

- 占位符 %d输出整数 %x十六进制整数 %f浮点数 %e科学计数法浮点数 %s格式化字符串

### switch语句用法

- switch语句根据switch(表达式)计算的结果，跳转到匹配case的结果，然后又执行后续的语句，知道遇到break语句执行结束。
```java
public class SwitchCase {
    public static void main(String[] agrs) {
        int options = 4;
        switch (options) {
            case 1:
                System.out.println("Selected 1");
               break;
            case 2:
                System.out.println("Selected 2");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            default:
                System.out.println("Selected default");
                break;
        }
    }
}
```

### 数组的使用

for() 循环遍历数组
```java
public class ArrayT {
    public static void main(String[] args) {
        int[] ns = {1,33,34,56,15};
        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }
}
```
forEach 循环遍历数组
```java
public class ArrayT {
    public static void main(String[] args) {
        int[] ns = {1,33,34,56,15};
        // forEach 循环
        for (int n: ns) {
            System.out.println(n);
        }
    }
}
```
- 值得注意的是foreach循环更加简洁，而且foreach循环拿不到每个数组的索引

- 1、如果打印数组内容会得到数组在JVM的引用地址。
```java
int[] ns = {23,1,34,32,15}
System.out.println(ns) // 类似 [I@7852e922
```
- java标准库提供了Arrays.toString()，快速打印数组内容
```java
System.out.print(Arrays.toString(ns));
```

### 冒泡排序

```java
public class MaoPaoT {
    public static void main(String[] args) {
        int[] ns = {23,32,13,34,3,45,31,9,18,5};
        System.out.print(Arrays.toString(ns));
        for (int i = 0; i < ns.length; i++) {
            for (int j = 0; j < ns.length - i -1; j++) {
                if(ns[j] > ns[j+1]) {
                    // 交换 ns[j] 和 ns[j+1]
                    int temp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = temp;
                }
            }
        }
        System.out.print(Arrays.toString(ns));
    }
}
```
- java JDK内置了排序功能 Arrays.sort()
```java
public class Main {
    public static void main(String[] args) {
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));
    }
}
```
### 二维数组的定义

```java
public class MoreArray {
  public static void main(String[] args) {
    int[][] ns = {
        {12, 1, 2, 3},
        {34, 3, 5, 4},
        {12, 45, 6, 0}
    };
    int[] arr0 = ns[0];
    System.out.print(Arrays.toString(arr0));
  }
}
```
- 打印二维数组 使用java标准库Arrays.deepToString()