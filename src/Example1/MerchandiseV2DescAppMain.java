package Example1;

import Example1.supermarket.MerchandiseV2;

import static Example1.supermarket.MerchandiseV2.*;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
       /* MerchandiseV2 merchandise = new MerchandiseV2();

        // >> TODO 调用方法，完成对成员变量的操作
        merchandise.init("书桌","DESK9527",40,999.9,500);
        merchandise.describe();*/

        //MerchandiseV2WithConstructor merchandise = new MerchandiseV2WithConstructor("书桌","DESK9527",40,999.9,500);

        // >> TODO 如果我们自己添加类构造方法，Java就不会再添加无参数的构造方法
        // >> TODO 这时候，就不能直接new一个对象不传递参数了 （看例子）
        // MerchandiseV2WithConstructor merchandise2 = new MerchandiseV2WithConstructor();

        //MerchandiseV2WithStaticVariable merchandise2 = new MerchandiseV2WithStaticVariable("椅子","chair9513",50,499,200);
        //merchandise2.describe();

        // >> TODO 使用import static来引入一个静态变量，就可以直接用静态变量名访问了
        // >> TODO import static 也可以使用通配符*来引入一个类里的所有静态变量
        //System.out.println(MerchandiseV2WithStaticVariable.DISCOUNT_FOR_VIP);

        MerchandiseV2 merchandise = new MerchandiseV2("书桌","DESK9527",40,999.9,500);
        merchandise.describe();

        System.out.println(getVIPDiscount());
    }

}
