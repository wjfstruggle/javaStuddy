package core.cdc.dome;

import java.util.StringJoiner;

/**
 * @program: notes
 * @description: 高效字符串拼接StringJoiner
 * @author: wujf
 * @create: 2019-08-14 14:18
 **/
public class Main10 {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        StringBuilder sb = new StringBuilder();
        String[] arr = {"Bon", "Buy", "apple"};
        sb.append("hello, ");
        for (String n : arr) {
            sb.append(n).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
        //  StringJoiner高效的字符串拼接
        StringJoiner sj = new StringJoiner(", ", "hello ", " !"); //delimiter拼接用的字符
        String[] names = {"Bon", "Buy", "apple"};
        for (String name : names) {
            sj.add(name);
        }
        System.out.println("StringJoiner add方法：" + sj.toString());
        String[] arr2 = {"Bob", "Alice", "Grace"};
        // join()方法更加简单
        String s = String.join(",", arr2);
        System.out.println(s);
    }

    static String buildSelectSql(String table, String[] fields) {
        StringJoiner sj = new StringJoiner(",", "SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        return sj.toString();
    }
}
