## java核心类

#### 字符串和编码

- 字符串方法

> equals比较字符串是否相同 `s.equals(s2)`

> equalsIgnoreCase()忽略大小写 `s.equalsIgnoreCase(s2)`

> // 是否包含子串:`"Hello".contains("ll"); // true`
```java
// 搜索字符串
"Hello".indexOf("l"); // 2
"Hello".lastIndexOf("l"); // 3
"Hello".startsWith("He"); // true
"Hello".endsWith("lo"); // true
// 提取字符串
"Hello".substring(2); // "llo"
"Hello".substring(2, 4); "ll" // 索引是从零开始的
// String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
"".isEmpty(); // true，因为字符串长度为0
"  ".isEmpty(); // false，因为字符串长度不为0
"  \n".isBlank(); // true，因为只包含空白字符
" Hello ".isBlank(); // false，因为包含非空白字符
```
#### StringBuilder

- append方法字符串拼接
```java
public class Main9 {
  public static void main(String[] args) {
    String[] fields = { "name", "position", "salary" };
    String table = "employee";
    String insert = buildInsertSql(table, fields);
    System.out.println(insert);// INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)
  }
  static String buildInsertSql(String table, String[] fileds) {
    StringBuilder sb = new StringBuilder(1024);
    sb.append("INSERT INTO " + table+ " (");
    for (int i = 0; i < fileds.length; i++) {
        sb.append(fileds[i]);
        if(i < fileds.length - 1) {
          sb.append(", ");
      }
    }
    sb.append(") VALUES (?, ?, ?)");
    return sb.toString();
  }
}
```

### StringJoiner高效字符串拼接

```java
public class Main10 {
  public static void main(String[] args) {
    String[] fields = { "name", "position", "salary" };
    String table = "employee";
    String select = buildSelectSql(table, fields);
    System.out.println(select);
    StringBuilder sb = new StringBuilder();
    String[] arr = {"Bon", "Buy","apple"};
    sb.append("hello, ");
    for (String n: arr) {
      sb.append(n).append(", ");
    }
    sb.delete(sb.length()-2, sb.length());
    System.out.println(sb.toString());
    //  StringJoiner高效的字符串拼接
    StringJoiner sj = new StringJoiner(", ","hello "," !"); //delimiter拼接用的字符
    String[] names = {"Bon", "Buy","apple"};
    for (String name: names) {
      sj.add(name);
    }
    System.out.println("StringJoiner add方法："+sj.toString());
    String[] arr2 = {"Bob", "Alice", "Grace"};
    // join()方法更加简单
    String s = String.join(",", arr2);
    System.out.println(s);
  }
  static String buildSelectSql(String table, String[] fields) {
    StringJoiner sj = new StringJoiner(",", "SELECT ", " FROM " + table);
    for (String field: fields) {
      sj.add(field);
    }
    return sj.toString();
  }
}
```
### 包装类型
- java核心库为每种基本类型都提供了对应的包装类型

|     基本类型       | abstract class|    |
| :-------------------------:   | :----------: | :----------:  |
| boolean   | 	java.lang.Boolean |  
| byte    | 	java.lang.Byte |   
| short    | 	java.lang.Short |   
| int    | 	java.lang.Boolean | 
| long    | 	java.lang.Integer | 
| float    | 	java.lang.Float | 
| double    | 	java.lang.Double | 
| char    | 	java.lang.Char | 
 ```java
  // 通过静态方法valueOf(String)创建Integer实例:
  Integer n3 = Integer.valueOf("100");
  System.out.println(n3.intValue());
```
### 枚举类

- enum

> 定义的enum类型总是继承自java.lang.Enum，且无法被继承；

> 只能定义出enum的实例，而无法通过new操作符创建enum的实例；

> 定义的每个实例都是引用类型的唯一实例；

> 可以将enum类型用于switch语句。

### 常用工具类

- Math
- Random
- SecureRandom
