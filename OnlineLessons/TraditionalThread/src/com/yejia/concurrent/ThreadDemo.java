package com.yejia.concurrent;

/**
 * Created by yejiapc on 15/12/25.
 */
public class ThreadDemo {

    public static void main(String[] args){
        Thread t = new ThreadA();
        t.setName("ThreadA");
        t.start();

//        Runnable r = new ThreadB();
//        Thread t2 = new Thread(r);
//        t2.start();

        while(true){
            try {
                t.sleep(1000);
//                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("3");
        }
    }
}

class ThreadA extends Thread{
    @Override
    public void run() {
//        super.run();
        while(true){
            System.out.println(this.getName()+" : " + 2);
        }
    }
}

//推荐
class ThreadB implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println(4);
        }
    }
}
