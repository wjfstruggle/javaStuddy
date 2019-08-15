package obj.cdc.dome;

/**
 * @program: notes
 * @description: 税收基数
 * @author: wujf
 * @create: 2019-08-14 08:58
 **/
public class SalaryIncome extends Income {
  public SalaryIncome(double income) {
    super(income);
  }
  @Override
  public double getIncome() {
    if (income < 5000) {
      return 0;
    }
    return (income - 5000) * 0.2;
  }
}
