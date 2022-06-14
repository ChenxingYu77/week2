package Example1;

import Example1.person.Customer;
import Example1.supermarket.LittleSuperMarket;
import Example1.supermarket.MerchandiseV2;

import java.util.Scanner;

public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.address = "世纪大道666号";
        littleSuperMarket.superMarketName = "有家超市";
        littleSuperMarket.parkingCount = 200;
        littleSuperMarket.merchandises = new MerchandiseV2[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        MerchandiseV2[] all = littleSuperMarket.merchandises;

        for (int i = 0;i<all.length;i++){
            MerchandiseV2 m = new MerchandiseV2();
            m.count = 200;
            m.id = "id" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1+Math.random()) * 200;
            all[i] = m;
        }

        System.out.println("超市开门啦！");

        boolean open = true;
        while(open) {
            System.out.println("本店叫做"+littleSuperMarket.superMarketName);
            System.out.println("本店地址"+littleSuperMarket.address);
            System.out.println("共有停车位"+littleSuperMarket.parkingCount+"个");
            System.out.println("今天的营业额为"+littleSuperMarket.incomingSum);
            System.out.println("共有商品"+littleSuperMarket.merchandises.length+"种");

            Customer customer = new Customer();
            customer.name="顾客编号"+(int)(Math.random()*10000);
            customer.money=(1+Math.random())*1000;
            customer.isDrivingCar=Math.random()>0.5;

            if(customer.isDrivingCar){
                if (littleSuperMarket.parkingCount>0){
                    System.out.println("欢迎"+customer.name+"驾车而来，本店已经为您安排了车位，停车免费。");
                    littleSuperMarket.parkingCount--;
                }else {
                    System.out.println("不好意思，本店车位已满。欢迎您下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎"+customer.name+"光临本店");
            }

            double totalCost = 0;
            while (true){
                System.out.println("本店提供"+all.length+"种商品，欢迎选购。请输入商品编号");
                int index = sc.nextInt();

                if (index<0){
                    break;
                }
                if (index>=all.length){
                    System.out.println("本店没有这种商品，请输入编号在0到"+(all.length-1)+"之内的商品编号。");
                    continue;
                }
                MerchandiseV2 m = all[index];

                System.out.println("您选购的商品名字"+m.id+"。单价是"+m.soldPrice+"。请问您要购买多少个？");
                int numToBuy = sc.nextInt();

                if (numToBuy<=0){
                    System.out.println("不买看看也好。欢迎继续挑选");
                    continue;
                }

                if (numToBuy>m.count){
                    System.out.println("本店此商品库存没有这么多，欢迎继续选购");
                    continue;
                }
                if (numToBuy*m.purchasePrice > customer.money){
                    System.out.println("您带的钱不够，欢迎继续挑选");
                    continue;
                }
                totalCost += numToBuy * m.soldPrice;

                m.count -= numToBuy;
                littleSuperMarket.merchandiseSold[index] += numToBuy;
            }

            customer.money -= totalCost;

            if (customer.isDrivingCar){
                littleSuperMarket.parkingCount++;
            }
            System.out.println("顾客"+customer.name+"共消费了"+totalCost);
            littleSuperMarket.incomingSum += totalCost;

            System.out.println("还继续营业吗？");
            open=sc.nextBoolean();
        }
        System.out.println("超市关门了！");
        System.out.println("今天总的营业额为"+littleSuperMarket.incomingSum+"。营业情况如下：");

        for (int i = 0; i < littleSuperMarket.merchandiseSold.length; i++) {
            MerchandiseV2 m = all[i];
            int numSold = littleSuperMarket.merchandiseSold[i];
            if (numSold>0){
                double incomming = m.soldPrice*numSold;
                double netIncomming = (m.soldPrice-m.purchasePrice)*numSold;
                System.out.println(m.id+"售出了"+numSold+"个。销售额为"+incomming+"。净利润为"+netIncomming);
            }

        }

        System.out.println("下面请利润最高的商品自我介绍：");
        littleSuperMarket.getBiggestProfitMerchandise().describe();
    }
}
