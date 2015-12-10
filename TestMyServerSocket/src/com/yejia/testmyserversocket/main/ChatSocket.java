package com.yejia.testmyserversocket.main;

import java.io.*;
import java.net.Socket;

/**
 * Created by yejiapc on 15/12/10.
 */
public class ChatSocket extends Thread {
    Socket socket;

    public ChatSocket(Socket s){
        this.socket = s;
    }

    public void out(String out) {
        try {
            socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        out("你已经连接到本服务器了");
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                ChatManager.getChatManager().publish(this, line);
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
