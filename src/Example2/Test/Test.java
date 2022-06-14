package Example2.Test;

public class Test {
    public void test(int a){
        a--;
    }

    public static void main(String[] args) {
        Test a = new Test();
        int aa = 5;
        System.out.println(aa);
        a.test(aa);
        System.out.println(aa);
    }
}


