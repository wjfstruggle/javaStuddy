package obj.cdc.dome;

/**
 * @program: notes
 * @description: 抽象类
 * @author: wujf
 * @create: 2019-08-14 09:18
 **/
public class AbstractClass {
    public static void main(String[] args) {
        SclarMoney money = new Money(90);
        System.out.println(money.run());// 8100
    }
}

abstract class SclarMoney {
    protected double moneys;

    public SclarMoney(double moneys) {
        this.moneys = moneys;
    }

    // 定义了抽象类就无法实例化。SclarMoney sclarmoney = new SclarMoney() 错误的
    public abstract double run();//如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法：
}

class Money extends SclarMoney {
    public Money(double moneys) {
        super(moneys);
    }

    @Override
    public double run() {
        return moneys * 90;
    }
}
