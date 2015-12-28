package com.yejia.myjavachatclient.main;

import java.util.Scanner;

/**
 * Created by yejiapc on 15/12/28.
 */
public class StartClient {

    public static void main(String[] args){
//        接受控制台输入
//        System.out.println("输入");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        if(read!=null){
//            连接服务器
            String ip = read;
            ChatManager.getCM().connect(ip);
        }
//
//        if(read.equals("")){
//            System.out.println("输入结束");
//        }else{
//            System.out.println("输入数据："+read);
//        }
//
//        read = scan.nextLine();
//        if(read.equals("")){
//            System.out.println("输入结束");
//        }else{
//            System.out.println("输入数据："+read);
//        }
    }
}
