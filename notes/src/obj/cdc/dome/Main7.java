package obj.cdc.dome;

/**
 * @program: notes
 * @description: 多态,在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）。
 * @author: wujf
 * @create: 2019-08-13 16:04
 **/
public class Main7 {
  public static void main(String[] args) {
    Animate p = new Pig();
    p.run(); // pig run
    p.run(); // pig run
    Income[] incomes = new Income[] {
        new Income(3000),
        new SalaryIncome(7000),
        new StateCouncilSpecialAllowance(15000)
    };
    System.out.println(totalIncome(incomes));
  }
  public static double totalIncome(Income... incomes) {
    double total = 0;
    for (Income income: incomes) {
      total += income.getIncome();
    }
    return total;
  };
}
class Animate {
  public void run() {
    System.out.println("animate run");
  }
}
class Pig extends Animate {
  @Override
  public void run() {
    System.out.println("pig run");
  }
}
// Income 税收
class Income {
  protected double income;
  public double getIncome() {
    return income * 0.1;
  }
  public Income(double income) {
    this.income = income;
  }
}
// 税收基数
class SalaryIncome extends Income{
  public SalaryIncome(double income) {
    super(income);
  }
  @Override
  public double getIncome() {
    if(income < 5000) {
      return 0;
    }
    return (income - 5000) * 0.2;
  }
}
//StateCouncilSpecialAllowance 免税
class StateCouncilSpecialAllowance extends Income {
  public StateCouncilSpecialAllowance(double income) {
    super(income);
  }
  @Override
  public double getIncome() {
    return 0;
  }
}