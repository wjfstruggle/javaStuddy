package core.cdc.dome;

/**
 * @program: notes
 * @description: 枚举类
 * @author: wujf
 * @create: 2019-08-14 15:52
 **/
public class Main12 {
  public static void main(String[] args) {
    WeekDay day = WeekDay.SAT;
    switch (day) {
      case SAT:
        System.out.println("周六");
        break;
      case SUN:
        System.out.println("周日");
        break;
      case MON:
        System.out.println("周一");
        break;
      case TUE:
        System.out.println("周二");
        break;
      case WED:
        System.out.println("周三");
        break;
      case THU:
        System.out.println("周四");
        break;
      case FRI:
        System.out.println("周五");
        break;
      default:
        throw new RuntimeException("can not process day"+ day);
    }
    if (day == WeekDay.SAT || day == WeekDay.SUN) {
      System.out.println("work at home");
    } else {
      System.out.println("work at office");
    }
  }
}
// enum
//为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用enum来定义枚举类：
enum WeekDay {
  SUN, MON, TUE, WED, THU, FRI, SAT;
}