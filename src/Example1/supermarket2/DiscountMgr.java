package Example1.supermarket2;

public class DiscountMgr {
    public static double BASE_DISCOUNT;
    public static double VIP_DISCOUNT;
    private NonPublicClassCanUseAnyName nonPublicClassCanUseAnyName;
    // >> TODO 使用某个静态变量的代码块必须在静态变量后面
    public static double SVIP_DISCOUNT;
    static {
        BASE_DISCOUNT = 0.99;
        VIP_DISCOUNT = 0.85;
        SVIP_DISCOUNT = 0.75;

        // >> TODO 静态代码块里当然可以有任意的合法代码
        System.out.println("静态代码块1里的SVIP_DISCOUNT" + SVIP_DISCOUNT);

        // >> TODO 这段代码在哪个方法中呢？ <clinit>, 即class init。会在每个class初始化的时候被调用一次

    }

    // >> TODO 其实给静态变量赋值也是放在代码块里，static代码块可以有多个，是从上向下顺序执行的
    // >> TODO 可以认为这些代码都被组织到了一个<clinit>方法里
    static{
        SVIP_DISCOUNT = 0.1;
        System.out.println("静态代码块2里的SVIP_DISCOUNT"+SVIP_DISCOUNT);
    }

    // >> TODO 静态方法的重载也是一样的，方法签名不同即可： 方法名+参数类型
    // >> TODO 判断调用哪个方法，也是根据调用时参数匹配决定的。
    public static double getDiscount(){
        return BASE_DISCOUNT;
    }

    public static double getDiscount(boolean isVIP){
        // >> TODO 三元操作符
        // double abc = true ? "" : 0;
        double svipDiscount = (isVIP ? VIP_DISCOUNT : 1);
        return getDiscount()*svipDiscount;
    }

    public static double getDiscount(int svipLevel){
        double ret = getDiscount()*VIP_DISCOUNT;
        for (int i = 0; i < svipLevel; i++){
            ret *= SVIP_DISCOUNT;
        }
        return ret;
    }

    // >> TODO 返回值不算是方法签名，重载的方法可以有完全不同的返回值类型
    public static void getDiscount(String s){
        System.out.println(s);
    }

    public static int getDiscount(int a,int b){
        return a>b ? a : b;
    }

    public static boolean getDiscount(int a,int b,int c){
        return a>b && b>c;
    }

    public static String getDiscount(long abc){
        return ""+abc;
    }

    public static void main(String[] args) {
        System.out.println("最终main方法中使用的SVIP_DISCOUNT是"+SVIP_DISCOUNT);
    }

}
