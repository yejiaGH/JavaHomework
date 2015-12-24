/**
 * Created by yejiapc on 15/12/24.
 */
public class UsingThreadPriority {

    public static void main(String[] args){
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}

class Runnable1 implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("线程1执行了"+(i+1)+"次");
        }
    }
}

class Runnable2 implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("线程2执行了"+(i+1)+"次");
        }
    }
}
