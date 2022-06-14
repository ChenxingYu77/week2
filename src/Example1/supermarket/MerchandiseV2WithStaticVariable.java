package Example1.supermarket;

public class MerchandiseV2WithStaticVariable {
    public String name;
    public String id;
    public double count;
    public double soldPrice;
    public double purchasePrice;

    // >> TODO 静态变量使用static修饰符
    // >> TODO 静态变量如果不赋值，Java也会给它赋以其类型的初始值
    // >> TODO 静态变量一般使用全大写字母加下划线分割。这是一个习惯用法
    // >> TODO 所有的代码都可以使用静态变量，只要根据防范控制符的规范，这个静态变量对其可见即可
    // >> TODO 比如public的静态变量，所有的代码都可以使用它
    public static double DISCOUNT_FOR_VIP = 0.95;

    // >> TODO 但是如果没有public修饰符，只能当前包的代码能使用它
    static int STATIC_VARIABLE_CURR_PACKAGE_ONLY = 100;

    public MerchandiseV2WithStaticVariable(String name,String id,int count,double soldPrice,double purchasePrice){
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }
    public void describe(){
        System.out.println("商品的名字叫做" + name + "，id是" + id + "，商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count + "。销售一个的毛利润是" + (soldPrice - purchasePrice) );
    }



}
