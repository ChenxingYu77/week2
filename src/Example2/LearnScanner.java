package Example2;

import java.math.BigInteger;
import java.util.Scanner;

public class LearnScanner {
    public static void main(String[] args) {
        // >> TODO Scanner是一个方便的可以帮我们从标准输入读取并转换数据的类
        // >> TODO 注释里 @since 1.5 表示它是从Java1.5才开始有的
        Scanner sc = new Scanner(System.in);

        // >> TODO Scanner是一个方便的可以帮我们从标准输入读取并转换数据的类
        // >> TODO Scanner是一个方便的可以帮我们从标准输入读取并转换数据的类
        // >> TODO Scanner是一个方便的可以帮我们从标准输入读取并转换数据的类
        System.out.println("请输入一个巨大的整数");
        BigInteger bigInteger = sc.nextBigInteger();
        System.out.println("请输入想给这个数加多少");
        BigInteger toBeAdd = sc.nextBigInteger();
        System.out.println("结果为" + bigInteger.add(toBeAdd));
    }
}
