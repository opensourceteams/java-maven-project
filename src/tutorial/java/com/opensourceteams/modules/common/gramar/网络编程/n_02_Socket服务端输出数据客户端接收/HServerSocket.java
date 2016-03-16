package com.opensourceteams.modules.common.gramar.网络编程.n_02_Socket服务端输出数据客户端接收;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:10
 * 功能描述:
 */

public class HServerSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);

        PrintStream output = null;
        Socket socket = null;

        while (true){
            socket = serverSocket.accept();
            InetAddress addr =  socket.getInetAddress();

            System.out.println("接收到了,客户端请求:" + addr.getHostName());

            output = new PrintStream(socket.getOutputStream());
            output.println("服务端数据");

            output.close();
            socket.close();
        }


    }
}
