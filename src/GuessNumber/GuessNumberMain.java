// 用类改造猜数字游戏

package GuessNumber;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberMain {
    public static void main(String[] args) {
        // new一个GuessNumber对象，设置对象属性
        GuessNumber guessNumber = new GuessNumber(10,100);
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        //游戏统计
        int totalGameCount = 0;
        int correctGuessCount = 0;

        //是否结束游戏
        boolean gameEnd = false;
        while (!gameEnd) {
            int rightNumber = guessNumber.randomGenerate(); // 系统生成一个1-100的随机整数

            int leftToGuess = guessNumber.maxCount;
            boolean currentGameCounted = false;
            boolean correctGuess = false;

            guessNumber.announce();
            while (leftToGuess>0) {
                System.out.println("剩余猜测次数"+leftToGuess+"。请输入本次猜测的数字：");
                int input = sc.nextInt();
                if(input<0){
                    gameEnd = true;
                    System.out.println("用户选择结束游戏");
                    break;
                }
                if (!currentGameCounted){
                    totalGameCount++;
                    currentGameCounted = true;
                }

                int results = guessNumber.compareResults(rightNumber,input);   // 比较正确数字与用户猜测数字的大小
                leftToGuess = guessNumber.countRound(leftToGuess,results);     // 统计用户剩余猜测次数
                correctGuess = guessNumber.overGame(correctGuess,results);     // 标记用户是否猜对数字
                if(correctGuess == true){
                    correctGuessCount++;
                    break;     // 如果用户猜对，则停止此次循环，进入下一轮猜测游戏
                }
                if (leftToGuess == 0){
                    System.out.println("本次的正确数字是："+rightNumber);
                }
            }
            System.out.println("共进行了"+totalGameCount+"次游戏，其中猜中的次数为"+correctGuessCount);
        }
    }
}