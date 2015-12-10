package com.yejia.testmyserversocket.main;

        import javax.swing.*;
        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;

/**
 * Created by yejiapc on 15/12/10.
 */
public class ServerListener extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while(true){
                // 阻塞main进程
                Socket socket = serverSocket.accept();
                // 建立连接
                JOptionPane.showMessageDialog(null, "有客户端连接到了本机的12345端口");
                // 将socket传递给新的线程
//                new ChatSocket(socket).start();
                ChatSocket cs = new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().add(cs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
