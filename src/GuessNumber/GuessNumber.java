package GuessNumber;

public class GuessNumber {
    // >> TODO 定义成员变量，包括猜测范围初始值与终止值,与每轮的最大猜测次数
    public int rangeStart;
    public int rangeEnd;
    public int maxCount = 5;

    // >> TODO GueseeNumber对象构造方法
    public GuessNumber(int rangeStart,int rangeEnd){
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    public GuessNumber(){}

    // >> TODO 访问与修改成员变量
    public int getRangeStart(){ return rangeStart;}
    public void setRangeStart(int start){this.rangeStart = start;}

    public int getRangeEnd(){ return rangeEnd;}
    public void setRangeEnd(int end){this.rangeEnd = end;}

    public int getMaxCount(){ return maxCount;}
    public void setMaxCount(int maxCount){this.maxCount = maxCount;}

    // >> TODO 定义一个方法，用于生成一个随机数
    public int randomGenerate(){
        int mod = this.rangeEnd - this.rangeStart;
        if (rangeStart < 0 || rangeEnd < 0) {
            System.out.println("开始和结束必须是正的");
        }
        if (mod <= 1) {
            System.out.println("非法的数字范围：(" + rangeStart + "," + rangeEnd + ")");
        }
        int bigRandom = (int) (Math.random() * rangeEnd * 100);
        int numberToGuess = (bigRandom % mod) + rangeStart;
        if (numberToGuess < rangeStart) {
            numberToGuess = rangeStart + 1;
        } else if (numberToGuess > rangeEnd) {
            numberToGuess = rangeEnd - 1;
        }
        return numberToGuess;
    }

    // >> TODO 定义一个方法，用于比较目标数字与猜测数字
    public int compareResults(int rightNumber,int guessNumber){
        int ret = 0;

        if(rightNumber > guessNumber ){
            System.out.println("你猜小了");
            ret = 1; // 猜小了

        } else if(rightNumber < guessNumber){
            System.out.println("你猜大了");
            ret = 2; // 猜大了
        } else {
            System.out.println("你猜对了");
            ret = 3;  // 猜对了
        }
        return ret;
    }

    // >> TODO 统计次数
    public int countRound(int roundRemain,int results){
        if (results == 1 | results == 2){
            roundRemain--;

        }
        return roundRemain;
    }

    // >> TODO 如果用户猜对，则标记用户猜对
    public boolean overGame(boolean guessCorrect,int results){
        if (results == 3){
            guessCorrect = true;
        }
        return guessCorrect;
    }

    // >> TODO 定义一个方法，用于描述游戏
    public void announce(){
        System.out.println("请输入猜测的数字，范围在("+this.rangeStart+","+this.rangeEnd+")。 输入-1代表结束游戏");
    }
}
