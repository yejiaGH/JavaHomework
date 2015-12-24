/**
 * Created by yejiapc on 15/12/24.
 */
public class UsingThreadMethod {
    public static void main(String[] args) throws InterruptedException {
//        MyThread thread = new MyThread();
//
//        System.out.println("线程状态： " + thread.isAlive());
//        thread.start();
//        System.out.println("线程状态： " + thread.isAlive());
//
//
//        System.out.println("线程名称： " + thread.getName());
//        System.out.println("取得当前线程对象的名字： " + Thread.currentThread().getName());

        boolean isExecute = false;

        for(int i=0; i<10; i++){
            if(i>2){
                if(!isExecute){
                    System.out.println("执行一次");
                    MyThread thread = new MyThread();
                    thread.start();
                    // 强制执行
                    thread.join();

                    isExecute = true;
                }
            }
            System.out.println("主线程执行第"+(i+1)+"次");
        }
        System.out.println("开始休眠");
        Thread.sleep(2000);
        System.out.println("结束休眠");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
//        super.run();
        for(int i=0;i<10; i++){
            System.out.println("自定义线程执行第"+(i+1)+"次");
        }
    }
}
