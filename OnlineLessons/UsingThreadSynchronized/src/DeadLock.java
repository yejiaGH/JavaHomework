/**
 * Created by yejiapc on 15/12/25.
 */
public class DeadLock {

    public static void main(String[] args){

        Object o1 = new Object();
        Object o2 = new Object();

        MyRunnable r1 = new MyRunnable("A",o1,o2,3000);
        MyRunnable r2 = new MyRunnable("B",o2,o1,300);
//        MyRunnable r2 = new MyRunnable("B",o1,o2,300);

        new Thread(r1).start();
        new Thread(r2).start();
    }
}

class MyRunnable implements  Runnable{
    private Object o1;
    private Object o2;
    private String threadNo;
    private int dur;

    public MyRunnable(String threadNo, Object o1, Object o2, int dur){
        this.threadNo = threadNo;
        this.o1 = o1;
        this.o2 = o2;
        this.dur = dur;
    }

    @Override
    public void run() {
        System.out.println("线程："+threadNo);
        synchronized (o1){
            try {
                Thread.sleep(dur);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o2){
                System.out.println("线程-"+threadNo);
            }
        }
    }
}
