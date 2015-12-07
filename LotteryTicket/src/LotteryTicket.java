import java.util.Random;

/**
 * Created by yejiapc on 15/12/7.
 */
public class LotteryTicket {
    static int[] lotteryNumbers = new int[7];

    public static void main(String[] args){



        for(int i=0; i<lotteryNumbers.length;i++){
            generateNumber(i);
//            System.out.print(lotteryNumbers[i] + " | ");
        }

        for(int i=0; i<lotteryNumbers.length;i++){
            System.out.print(lotteryNumbers[i] + " | ");
        }
    }

    private static void generateNumber(int index){
        int rand;
        int from;

        if(index<5){
            rand = 1+ new Random().nextInt(35);
            from = 0;
        }else{
            rand = 1+ new Random().nextInt(12);
            from = 5;
        }

        if(noRepeat(from, index, rand)){
            lotteryNumbers[index] = rand;
        }else{
            generateNumber(index);
        }

    }

    private static boolean noRepeat(int from, int index, int rand){

        System.out.println("from: "+ from+", index: "+index+", rand: "+ rand);
        for(int i = from; i<index; i++){
            if(lotteryNumbers[i] == rand){
                return false;
            }
        }

        return true;
    }
}
