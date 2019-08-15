package core.cdc.dome;

import java.util.Arrays;

/**
 * @program: notes
 * @description: 使用StringBuilder构造一个INSERT语句
 * @author: wujf
 * @create: 2019-08-14 11:30
 **/
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
