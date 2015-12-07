import java.util.Random;

/**
 * Created by yejiapc on 15/12/7.
 */
public class FindMax {

    public static void main(String[] args){

        int[] numbers = new int[10];

        for(int i=0; i<numbers.length;i++){
            int rand = new Random().nextInt();
            numbers[i] = rand;
            System.out.println(numbers[i]);
        }

        int max = findMax(numbers);
        System.out.println("最大数是"+max);
    }

    private static int findMax(int[] array){
        int temp = array[0];

        for(int i=0; i<array.length;i++){
            if(i>0){
                if(array[i] >= temp){
                    temp = array[i];
                }
            }
        }
        return temp;
    }
}
