/**
 * Created by yejiapc on 15/12/24.
 */
public class UsingThreadSynchronized extends Thread{

    private String threadNo;
    private Object obj;

    public UsingThreadSynchronized(Object obj, String threadNo){
        this.obj = obj;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
//        super.run();
//        对象锁, 实现线程同步
        synchronized (obj){
            for(int i=1; i<=1000; i++){
                System.out.println("线程"+threadNo+"执行了第"+i+"次");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object obj = new Object();
        for(int i=1;i<=5;i++){
            new UsingThreadSynchronized(obj, i+"").start();
            Thread.sleep(1);
        }
    }
}
