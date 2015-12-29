package com.yejia.synctime.main;

import java.util.Scanner;

/**
 * Created by yejiapc on 15/12/28.
 */
public class StartClient {

    public static void main(String[] args){
//        接受控制台输入
        System.out.println("请输入IP地址");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        if(read!=null){
//            连接服务器
            String ip = read;
            ChatManager.getCM().connect(ip);
        }
//
//        输入回车结束客户端程序
        read = scan.nextLine();
        if(read.equals("")){
            ChatManager.getCM().disconnect();
            System.out.println("退出客户端程序");
            System.exit(0);
        }

    }
}
