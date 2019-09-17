package obj.cdc.dome;

public interface BuyShop {
    void run();

    String getName();
}

/**
 * 当一个具体的class去实现一个interface时，需要使用implements关键字。
 * 所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）。
 **/
class Dish implements BuyShop {
    private String name;

    public Dish(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Dish run");
    }

    @Override
    public String getName() {
        return this.name;
    }
}

interface Win {
    void run();
}

// 此时Loser接口就有三个抽象方法签名，其中一个来自Win接口
interface Loser extends Win {
    void buy();

    String getName();
}
