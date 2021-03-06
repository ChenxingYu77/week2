package Example2;

public class LearnString2 {
    public static void main(String[] args) {
        String content = "Orange_Apple_Banana";

        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        String[] s = content.split("_");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        int indexOf = content.indexOf('_');
        System.out.println(indexOf);
        System.out.println(content.substring(indexOf+1,content.length()));

        int lastIndexOf = content.lastIndexOf('_');
        System.out.println(lastIndexOf);
        System.out.println(content.substring(lastIndexOf+1,content.length()));

        System.out.println(content.contains("apple"));
        System.out.println(content.contains("Apple"));
        System.out.println(content.contains("Orange"));
        System.out.println(content.contains("Banana"));

        String content2 = "Orange_Apple_Banana";
        String content3 = "orange_apple_banana";

        // TODO 两个String对象比较是否相等，一定要用equals方法
        System.out.println(content.equals(content2));
        System.out.println(content.equals(content3));
        System.out.println();
        System.out.println(content.equalsIgnoreCase(content3));

        String str = "  abc  ";
        System.out.println(str);
        System.out.println(str.trim());
    }
}
