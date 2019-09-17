package obj.cdc.dome;

import java.util.Arrays;

/**
 * @program: notes
 * @description: 方法
 * @author: wujf
 * @create: 2019-08-13 11:24
 **/
public class Main1 {
    public static void main(String[] agrs) {
        Book n = new Book();
//    n.setName("金字塔原理");
//    n.setPrice(88.90);
        n.setNames("罗威的森林", "或者", "创业值");
        n.setNamePrice("时间管理", 67.6);
        System.out.println(n.getName() + n.getPrice());
        System.out.println(Arrays.toString(n.getNames()));
    }
}

class Book {
    private String name;
    private String[] names;
    private double price;

    // method来让外部代码简洁修改字段。
    public String getName() {
        return this.name;
    }

    //  public void setName(String name) {
//    this.name = name;
//  }
    public double getPrice() {
        return this.price;
    }

    //  public void setPrice(double price) {
//    this.price = price;
//  }
    public void setNamePrice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //  多个参数的额传入
    public String[] getNames() {
        return this.names;
    }

    public void setNames(String... names) {
        this.names = names;
    }
}
