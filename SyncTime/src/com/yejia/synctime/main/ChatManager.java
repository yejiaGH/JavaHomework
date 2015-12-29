package com.yejia.synctime.main;

import java.io.*;
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
                    writer = new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));

                    reader = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

                    String line;
//                    接收服务端返回给客户端的系统时间字符串
                    while((line = reader.readLine()) != null){
                        System.out.println("收到服务端授时: "+line);
                    }
                    writer.close();
                    reader.close();
                    writer = null;
                    reader = null;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void disconnect(){
        try {
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
