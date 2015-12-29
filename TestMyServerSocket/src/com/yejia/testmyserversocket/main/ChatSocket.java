package com.yejia.testmyserversocket.main;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

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
//        取得服务器时间
        Date d1 = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String serverTime = sdf.format(d1);
//        向客户端输出服务器端时间
        out(serverTime);

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
