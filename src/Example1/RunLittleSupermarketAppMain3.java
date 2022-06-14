package Example1;

import Example1.supermarket.LittleSuperMarket;
import Example1.supermarket.MerchandiseV2;

import static Example1.supermarket.MerchandiseV2.*;
public class RunLittleSupermarketAppMain3 {
    public static void main(String[] args) {
        //创建一个小超市类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.init("有家小超市","浦东新区世纪大道666号",100,200,200);
        System.out.println(getDiscountOnDiscount(littleSuperMarket));

        System.out.println("下面请利润最高的商品自我介绍：");
        MerchandiseV2 bigProfit = littleSuperMarket.getBiggestProfitMerchandise();
        bigProfit.describe();
        double cost1 = bigProfit.buy(10,true);
        System.out.println("VIP购买10个"+bigProfit.name+"的花费为"+cost1);

        // >> TODO 使用别的类的静态变量的时候，需要使用完整形态：类名.静态变量名字
        MerchandiseV2.DISCOUNT_FOR_VIP = 0.5;
        bigProfit.describe();
        double cost2 = bigProfit.buy(10,true);
        System.out.println("VIP购买10个"+bigProfit.name+"的花费为"+cost2);

        // >> TODO 静态变量在整个Java程序中只有一个（对比实例变量，是每个实例都有一份
        // >> TODO 所以静态变量一旦变化，所有使用这个静态变量的地方的值都会变
        MerchandiseV2 m0 = littleSuperMarket.getMerchandiseOf(0);
        m0.describe();
        double cost3 = m0.buy(10,true);
        System.out.println("VIP购买10个"+m0.name+"的花费为"+cost2);



    }
}
