package obj.cdc.dome;

/**
 * @program: notes
 * @description: 免税
 * @author: wujf
 * @create: 2019-08-14 09:00
 **/
public class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getIncome() {
        return 0;
    }
}
