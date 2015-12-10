package com.yejia.testmyserversocket.main;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by yejiapc on 15/12/10.
 */
public class MyServerSocket {
//    1-65535
    public static void main(String[] args){

        new ServerListener().start();
    }
}
