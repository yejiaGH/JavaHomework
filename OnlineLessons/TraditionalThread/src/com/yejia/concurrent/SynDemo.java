package com.yejia.concurrent;

/**
 * Created by yejiapc on 15/12/25.
 */
public class SynDemo {

    public static void main(String[] args){
        Data d = new Data();
        new ThreadC(d).start();
        new ThreadC(d).start();
    }
}

class Data{
    int i;
    byte[] lock = new byte[0];
//    同步方法
//    public synchronized void process(){
public void process(){
//        加锁， 同步块，粒度细
//        synchronized (this){
    synchronized (lock){
            System.out.println("Before: "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        synchronized (lock){
            i++;
//        }

            System.out.println("After: "+i);
        }
    }
}

class ThreadC extends Thread{
    Data d;
    public ThreadC(Data d){
        this.d = d;
    }

    @Override
    public void run() {
        while(true){
            d.process();
        }
    }
}