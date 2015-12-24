/**
 * Created by yejiapc on 15/12/24.
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {

        for(int i=0; i<10; i++){
            System.out.println("this is MyThread2");
        }
    }
}
