package com.yejia.myjavachatclient.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by yejiapc on 15/12/28.
 */
public class ChatManager {

    private ChatManager(){}
//   单例化
    private static final ChatManager instance = new ChatManager();
    public static ChatManager getCM(){
        return instance;
    }

    Socket socket;
    String _ip;
//    输入流
    BufferedReader reader;
//    输出流
    PrintWriter writer;

    public void connect(String ip){
        this._ip = ip;
        new Thread(){
            @Override
            public void run() {
                try {
                    socket = new Socket(_ip,12345);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void send(String msg){

    }
}
