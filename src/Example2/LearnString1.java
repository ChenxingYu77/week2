package Example2;

import java.util.Locale;

public class LearnString1 {
    public static void main(String[] args) {
        String content = "0123456789asDEFsh";

        // String的length()是个方法而不是属性
        System.out.println(content.length());

        // 其实是生成了一个新的String对象
        System.out.println(content.toUpperCase());
        System.out.println(content.toLowerCase());

        // content指向对象的内容并没有变化
        System.out.println(content);
        System.out.println(content.charAt(3));
        System.out.println(content.substring(5));
        System.out.println(content.substring(3,9));
    }
}
