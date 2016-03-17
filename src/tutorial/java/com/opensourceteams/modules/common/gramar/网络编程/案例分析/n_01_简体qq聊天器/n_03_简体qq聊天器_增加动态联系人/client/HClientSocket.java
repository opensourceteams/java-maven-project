package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_03_简体qq聊天器_增加动态联系人.client;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_03_简体qq聊天器_增加动态联系人.view.QQMainWindow;
import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:09
 * 功能描述:
 */

public class HClientSocket {

    public static void main(String[] args) throws IOException, InterruptedException {


        QQMainWindow qqMainWindow = QQMainWindow.getInstance();
        Thread.sleep(1000);

        String host = "192.168.12.2";
        host = "localhost";
        //host ="192.168.12.9";
        Socket socket = new Socket(host,1234);
        System.out.println("客户端发送请求...");


        /**
         * 客户端写
         */
        BufferedWriter writer = null ;
        FileBufferedUtil.writerStringNoClose(writer,socket.getOutputStream(),"你好\r\n aa");


        /**
         * 客户端读
         */
        BufferedReader reader = null;
        StringBuilder sb = FileBufferedUtil.readerStringBuilderNoClose(reader,socket.getInputStream());
        System.out.println("客户端接收服务器返回的数据 : " + sb.toString());
        qqMainWindow.refleshContractTable2();

        if(reader!= null){
            reader.close();
        }

        if(writer!= null){
            writer.close();
        }

        if(socket!= null){
            socket.close();
        }


        System.out.println("over");


    }
}
