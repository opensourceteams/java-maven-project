package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.client;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.client.network.ClientMessageReceiverThread;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.view.QQMainWindow;
import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:09
 * 功能描述:
 */

public class HClientSocket {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {


        QQMainWindow qqMainWindow = QQMainWindow.getInstance();

        String host = "192.168.12.2";
        host = "localhost";
        //host ="192.168.12.9";
        Socket socket = new Socket(host,1234);
        System.out.println("客户端发送请求...");

        ClientMessageReceiverThread clientMessageReceiverThread = new ClientMessageReceiverThread(socket,qqMainWindow);
        clientMessageReceiverThread.start();




        /**
         * 客户端写
         */
        BufferedWriter writer = null ;
        FileBufferedUtil.writerStringNoClose(writer,socket.getOutputStream(),"你好\r\n aa");





        System.out.println("客户端结束");


    }
}
