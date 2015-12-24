/**
 * Created by yejiapc on 15/12/24.
 */
public class UsingThread {
    public static void main(String[] args){
//        Thread myThread = new MyThread();
//        myThread.start();

        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
}
