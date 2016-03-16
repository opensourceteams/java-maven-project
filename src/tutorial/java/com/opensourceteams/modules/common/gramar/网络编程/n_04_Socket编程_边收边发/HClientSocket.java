package com.opensourceteams.modules.common.gramar.网络编程.n_04_Socket编程_边收边发;

import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.*;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:09
 * 功能描述:
 */

public class HClientSocket {

    public static void main(String[] args) throws IOException {
        String host = "192.168.12.2";
        host = "localhost";
        //host ="192.168.12.9";
        Socket socket = new Socket(host,1234);
        System.out.println("客户端发送请求...");


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

        writer.write("你好a");
        writer.newLine();
        writer.write("你好b");

        writer.flush();


        /**
         * 客户端读
         */
        StringBuilder sb = FileBufferedUtil.readerNoEnd(socket.getInputStream());
        System.out.println("客户端接收服务器返回的数据 : " + sb.toString());

        writer.close();


        socket.close();
    }
}
