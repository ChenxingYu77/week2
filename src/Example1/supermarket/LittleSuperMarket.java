package Example1.supermarket;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public MerchandiseV2[] merchandises;
    public int[] merchandiseSold;
    public double activityDiscount = 0.9;

    public LittleSuperMarket(String superMarketName,String address,int parkingCount){
        this.superMarketName =superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
    }

    public LittleSuperMarket(){};

    public void init(String superMarketName,String address,int parkingCount,int merchandiseCount,int count){
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        merchandises = new MerchandiseV2[merchandiseCount];
        for (int i = 0; i < merchandises.length; i++) {
            // 创建并给商品的属性赋值
            MerchandiseV2 m = new MerchandiseV2();
            m.name = "商品" + i;
            m.count = count;
            m.purchasePrice = Math.random()*200;
            m.soldPrice = m.purchasePrice*(1+Math.random());
            m.id = "ID" + i;
            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品数组引用指向的是同一个数组对象
            merchandises[i] = m;
        }
        merchandiseSold = new int[merchandises.length];
    }
    // >> TODO 返回值可以是类名，这时候实际返回的值就是这个类的引用
    public MerchandiseV2 getBiggestProfitMerchandise(){
        MerchandiseV2 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV2 m = merchandises[i];
            if (curr==null){
                curr = m;
                continue;
            }
            // >> TODO 调用商品中定义的方法，不同的实例调用相同的方法，虽然代码相同，但是每个实例内部的数据不同，所以返回值也不同
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();
            if (currProfit<newProfit){
                curr = m;
            }
        }
        return curr;
    }

    public MerchandiseV2 getBiggestProfitMerchandise2(){
        MerchandiseV2 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV2 m = merchandises[i];
            if(curr==null){
                curr=m;
            } else{
                if(curr.calculateProfit()<m.calculateProfit()){
                    curr=m;
                }
            }
        }
        return curr;
    }

    // 简单的访问成员变量
    public String getSuperMarketName(){
        return superMarketName;
    }

    public String getAddress(){
        return address;
    }

    public int getParkingCount(){
        return parkingCount;
    }

    public double getIncomingSum(){
        return incomingSum;
    }

    public void setSuperMarketName(String superMarketName){
        this.superMarketName = superMarketName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setParkingCount(int parkingCount){
        this.parkingCount = parkingCount;
    }

    public void setIncomingSum(double incomingSum){
        this.incomingSum = incomingSum;
    }

    public void setMerchandises(MerchandiseV2[] merchandises){
        this.merchandises = merchandises;
    }

    public void setMerchandiseSold(int[] merchandiseSold){
        this.merchandiseSold = merchandiseSold;
    }

    /**
     * 根据索引获取商品
     */
    public MerchandiseV2 getMerchandiseOf(int merchandiseIndex){
        if (merchandiseIndex<0 || merchandiseIndex>=merchandises.length){
            return null;
        }
        return merchandises[merchandiseIndex];
    }

    /**
     * 赚钱
     */
    public void addIncomingSum(double toBeAdded){
        this.incomingSum += toBeAdded;
    }

    /**
     * 花钱
     */
    public boolean spendMoney(double toBeSpend){
        if (toBeSpend>incomingSum){
            return false;
        }
        incomingSum -= toBeSpend;
        return true;
    }
}
