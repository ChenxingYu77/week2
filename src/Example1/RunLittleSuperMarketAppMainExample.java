package Example1;

import Example1.supermarket.LittleSuperMarket;
import Example1.supermarket.MerchandiseV2;

public class RunLittleSuperMarketAppMainExample {
    public static void main(String[] args) {
        // 创建一个超市类
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket("世纪大道666号","有家超市",100);

        // 给超市200种商品
        littleSuperMarket.merchandises = new MerchandiseV2[200];
        // 统计用的数组
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        // 为了使用方便，创建一个商品数组引用，和littleSuperMarket.merchandises指向同一个数组对象
        MerchandiseV2[] all = littleSuperMarket.merchandises;

        MerchandiseV2 giftNoodle = new MerchandiseV2();
        giftNoodle.name = "赠品-面条";
        giftNoodle.count = 2000;
        giftNoodle.purchasePrice = 5;
        giftNoodle.soldPrice = 0.05;
        giftNoodle.id = "GIFT001";

        MerchandiseV2 giftBowl = new MerchandiseV2();
        giftBowl.name = "赠品-碗";
        giftBowl.count = 2000;
        giftBowl.purchasePrice = 8;
        giftBowl.soldPrice = 0.08;
        giftBowl.id = "GIFT002";
        // 便利并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            MerchandiseV2 m = new MerchandiseV2();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = Math.random()*200;
            m.soldPrice = m.purchasePrice*(1+Math.random());
            m.id = "ID" + i;
            m.gift = giftNoodle;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            all[i] = m;
        }

/*        int index = 0;
        MerchandiseV2 m = littleSuperMarket.merchandises[index];

        // >> TODO 方法的代码可以影响方法之外的数据。我们可以通过指向同一个对象的引用，操作这个对象里的属性
        MerchandiseV2 paramRef = littleSuperMarket.merchandises[2];

        m.gift = giftBowl;
        System.out.println("gift变换大法执行前");
        m.describe();
        paramRef.describe();
        m.changeToTheSameGift(paramRef);
        System.out.println("gift变换大法执行后");
        paramRef.describe();

        MerchandiseV2 gift0fm;

        //>> TODO 可以通过返回值，操作同一个对象

        System.out.println("获取m的赠品，并修改这个赠品对象的采购价格");
        System.out.println("修改前");
        m.describe();
        gift0fm = m.getGiftAndHowCanOutsideChangeIt();
        gift0fm.purchasePrice = gift0fm.purchasePrice*10;
        System.out.println("修改后");
        m.describe();*/




 /*       Scanner sc = new Scanner(System.in);
        MerchandiseV2 m0 = all[0];
        while (true){
            System.out.println("今日超市大优惠，所有商品第二件半价，选择要购买的商品索引：");
            int index = sc.nextInt();

            if(index<0){
                break;
            }
            if(index>all.length){
                System.out.println("商品索引超出界限");
                continue;
            }

            MerchandiseV2 m = all[index];
            System.out.println(m.isTheBiggestToalValueOne(littleSuperMarket));
            System.out.println("商品"+m.name+"售价为"+m.soldPrice+"。请问购买几个");
            int numToBuy = sc.nextInt();
            double totalCost = m.buyAndPrintLeft(numToBuy,true);
            boolean m0BiggerThan = m0.totalValueBiggerThan(m);
            System.out.println("m0的总价值比用户选择的要大"+m0BiggerThan);
            System.out.println("选购的商品总价为"+totalCost);
     } */

        System.out.println("LittleSuperMarket的对象是：" + littleSuperMarket);
        System.out.println("下面请利润最高的商品自我介绍：");
        MerchandiseV2 m =littleSuperMarket.getBiggestProfitMerchandise();
        m.describe();
        /*System.out.println("利润最高的MerchandiseV2对象是：" + m);
        if(!m.hasEnoughCountFor(500)){
            System.out.println("补充库存");
            int toBeAdded = 500;
            littleSuperMarket.incomingSum -= toBeAdded * m.purchasePrice;
            m.addCount(toBeAdded);
        }*/

        System.out.println("调用makeEnoughForOneByOne");
        m.makeEnoughForOneByOne(900);
        m.describe();
    }
}
