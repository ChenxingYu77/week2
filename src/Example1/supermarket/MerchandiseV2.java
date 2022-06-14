package Example1.supermarket;

/**
 * 对这个类的说明
 *
 * @author 9527
 * @since 2022
 */
// >> TODO 类，静态方法，静态变量，成员变量，构造方法，成员方法都可以使用访问修饰符

public class MerchandiseV2 {
    // >> TODO 成员变量应该都声明为private
    // >> TODO 如果要读写这些成员变量，最好使用get set方法，这些方法应该是public的
    // >> TODO 这样做的好处是，如果有需要，可以通过代码，检查每个属性值是否合法
    public String name;
    public String id;
    public double count;
    public double soldPrice;
    public double purchasePrice;
    public MerchandiseV2 gift;

    // >> TODO 静态变量使用static修饰符
    public static double DISCOUNT_FOR_VIP = 0.95;

    // >> TODO 静态方法使用static修饰符
    public static double getVIPDiscount(){
        // >> TODO 静态方法可以访问静态变量，包括自己类的静态变量和在访问控制符允许的别的类的静态变量
        return DISCOUNT_FOR_VIP;
    }

    // >> TODO 除了没有this，静态方法的定义和成员方法一样，也有方法名，返回值和参数
    // >> TODO 静态方法没有this自引用，它不属于某个实例，调用的时候也无需引用，直接用类名调用，所以它也不能直接访问成员变量
    // >> TODO 当然在静态方法里面，也可以自己创建对象，或者通过调用参数，获得对象的引用，进而调用方法和访问成员变量
    // >> TODO 静态方法只是没有this自引用的方法而已
    public static double getDiscountOnDiscount(LittleSuperMarket littleSuperMarket){
        double activityDiscount = littleSuperMarket.activityDiscount;
        return DISCOUNT_FOR_VIP*activityDiscount;
    }

    // >> TODO 构造方法如果是private的，那么只有当前的类可以调用这个构造方法
    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    // >> TODO 有些时候，会把所有的构造方法都定义成private的，然后使用静态方法调用构造方法
    // >> TODO 同样的，这样的好处是可以通过代码，检查每个属性值是否合法
    public static MerchandiseV2 createMerchandise(String name,String id,int count,double soldPrice,double purchasePrice){
        if (soldPrice<0 || purchasePrice<0){
            return null;
        }
        return new MerchandiseV2(name,id,count,soldPrice,purchasePrice);
    }





    // >> TODO 在构造方法里才能调用重载的构造方法。 语法为this(实参列表)
    // >> TODO 构造方法不能自己调用自己，这会是一个死循环
    // >> TODO 在调用重载的构造方法时，不可以使用成员变量。因为用语意上讲，这个对象还没有被初始化完成，处于中间状态
    // >> TODO 在构造方法里才能调用重载的构造方法时，必须是方法的第一行。后面可以继续有代码


    public MerchandiseV2(String name, String id, int count, double soldPrice) {
        this(name,id,count,soldPrice,soldPrice*0.8);
    }

    // >> TODO 因为我们添加了构造方法之后，Java就不会再添加无参数的构造方法，如果需要的话，我们可以自己添加这样的构造方法
    public MerchandiseV2(){
        this("无名","000",0,1,1.1);
    }

    public void init(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    // >> TODO 访问修饰符
    // >> TODO 返回值类型：无需返回值则用void表示，void是Java中的关键字
    // >> TODO 方法名：任意合法的标志符都可以
    // >> TODO 参数列表：后续讲解
    // >> TODO 方法体：方法的代码

    // >> TODO public的方法类似一种约定，既然外面的代码可以使用，就意味着不能乱改。比如签名不能改之类的
    public void describe() {
        System.out.println("商品的名字叫做" + name + "，id是" + id + "，商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count + "。销售一个的毛利润是" + (soldPrice - purchasePrice)+"。折扣为"+DISCOUNT_FOR_VIP);
    }

    // >> TODO 在方法定义中指定方法的返回类型
    // >> TODO Java中一个方法只能有一种返回值，如果不需要返回值则用void表示
    // >> TODO 如果定义了返回值，则必须使用return语句返回方法的返回值，return是Java的关键字
    // >> TODO 可以认为，返回值必须要能够用来给返回值类型的变量赋值
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        // >> TODO 这个return是代码块里的return，是return所在代码块的最后一个语句
        if (profit <= 0) {
            return 0;
        }
        return profit;

        // >> TODO 一个方法可以有多个返回语句
    }

    // >> TODO 参数是定义在方法名字后面的括号里的
    // >> TODO 参数定义的规范和变量一样，都是类型名字加标识符，这里的标识符我们叫做参数名
    // >> TODO 方法体中的代码可以使用参数
    // >> TODO 参数的值在调用方法的时候需要给出，有的资料叫做实参 （实际参数）
    // >> TODO 对应的，方法定义这里的参数，叫做形参（形式参数）

    //如果返回值是负数，就代表购买失败，比如库存不足
    /*public double buy(int countToBuy) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }

        System.out.println("商品单价为" + purchasePrice);
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + purchasePrice * halfPriceCount / 2;

        count -= countToBuy;
        return totalCost;
    }
*/

    public String getName(){return name;};
    public void setName(String name){this.name = name;}
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public double getCount(){return count;}
    public void setCount(double count){this.count = count;}
    public double getSoldPrice(){return soldPrice;}
    public void setSoldPrice(double soldPrice){this.soldPrice = soldPrice;}
    public double getPurchasePrice(){return purchasePrice;}
    public void setPurchasePrice(double purchasePrice){this.purchasePrice = purchasePrice;}


    // >> TODO 一个方法可以有多个参数苏，多个参数之间用逗号隔开
    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            if (printLeft) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }
        System.out.println("商品单价为" + purchasePrice);
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + purchasePrice * halfPriceCount / 2;

        count -= countToBuy;

        if (printLeft) {
            System.out.println("商品剩余库存为" + count);
        }

        return totalCost;
    }

    // >> TODO 参数可以是任何类型，包括自定义类型，甚至是自己的类型都没问题
    public boolean totalValueBiggerThan(MerchandiseV2 merchandiseV2) {
        return count * purchasePrice > merchandiseV2.purchasePrice * merchandiseV2.count;
    }

    // >> TODO 参数可以是任何类型，包括自定义类型
    public boolean isTheBiggestToalValueOne(LittleSuperMarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < littleSuperMarket.merchandises.length; i++) {
            MerchandiseV2 m = littleSuperMarket.merchandises[i];
            double newTotalValue = m.count * m.purchasePrice;
            if (totalValue < newTotalValue) {
                return false;
            }
        }
        return true;
    }

    // ------------参数-----------
    // >> TODO 参数的传递，其实就是赋值，左边是形参，右边是括号里的实参
    // >> TODO 参数本身可以是一个表达式，只要表达式的值类型可以和参数类型匹配就可以
    // >> TODO 对于引用类型，参数同样可以是一个表达式
    // >> TODO 方法里的代码并不能改变实参的值
    // >> TODO 方法里使用的参数相当于一个局部变量。使用方法前，会用实参给局部变量赋值

    // >> TODO 方可以把有返回值的方法，当成一个成员变量，当成一个类型为返回值类型的成员变量
    // >> TODO 关注与返回值并忽略方法执行的部分，使用返回值，就好像在使用一个成员变量

    public void changeToTheSameGift(MerchandiseV2 m2) {
        m2.gift = gift;
    }

    public MerchandiseV2 getGiftAndHowCanOutsideChangeIt() {
        return gift;
    }

    // >> TODO 返回值如果是基本类型，则要类型完全相同，或者符合类型自动转换规则
    public double getCurrentCount() {
        return count;
    }


    // >> TODO 方法里隐藏着一个this自引用，指向调用这个方法的对象
    // >> TODO 使用一个对象调用方法，也叫作在这个对象上调用方法。因为方法可以访问这个对象的值
    // >> TODO 访问一个成员变量的完整形态，是“this.成员变量的名字”
    public void addCount(int count) {
        this.count += count;
        System.out.println("MerchandiseV2的addCount方法使用的对象是：" + this);
    }

    public boolean hasEnoughCountFor(int count) {
        System.out.println("MerchandiseV2的hasEnoughCountFor方法使用的对象是：" + this);
        return this.count >= count;
    }

    /**
     * 这是一个方法注释，检查库存够不够数
     *
     * @param count 目标库存数
     * @return 达到目标库存数，则为true， 否则为false
     */
    public void makeEnoughForOneByOne(int count) {
        boolean hasEnough = this.hasEnoughCountFor(count);
        if (!hasEnough) {
            this.addCount(1);
            makeEnoughForOneByOne(count);
        }
    }

    // TODO 重载的方法可以调用别的重载方法，当然也可以调用别的不重载的方法
    // TODO 实际上，像这种补充一些缺省的参数值，然后调用重载的方法，是重载的一个重要的使用场景
    // TODO 在这里我们举的例子是这样的，但是不是语法要求一定要这样。重载的方法的方法体内代码可以随便
    // TODO 可以不调用别的重载方法

    // TODO 为了使用方便，买一个，不传参数
  /*  public double buy(){
        return buy(1);
    }

    // TODO 买好几个
    public double buy(int count){
        return buy(count,false);
    }
*/
    // TODO VIP会员 购买九五折
    public double buy(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            return totalCost * DISCOUNT_FOR_VIP;
        } else {
            return totalCost;
        }
    }

    // TODO 论斤卖的商品，数量是double。我们把count成员变量改成double类型
    public double buy(double count) {
        System.out.println("buy(double)被调用了");
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        return totalCost;
    }

    public double buy() {
        System.out.println("buy()被调用了");
        return buy(1);
    }

    public double buy(int count) {
        System.out.println("buy(int)被调用了");
        return buy(count, false);
    }
}

