package obj.cdc.dome;

/**
 * @program: notes
 * @description: 基本税收
 * @author: wujf
 * @create: 2019-08-14 09:07
 **/
public class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income * 0.1;
    }
}
