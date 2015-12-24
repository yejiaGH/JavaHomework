/**
 * Created by yejiapc on 15/12/24.
 */
public class UsingThreadSynchronized extends Thread{

    private String threadNo;

    public UsingThreadSynchronized(String threadNo){
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
//        super.run();
        for(int i=1; i<=10; i++){
            System.out.println("线程执行了第"+i+"次");
        }
    }

    public static void main(String[] args){

    }
}
