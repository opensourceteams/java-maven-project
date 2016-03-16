package com.opensourceteams.modules.common.gramar.网络编程Socket编程;

import java.io.IOException;
import java.net.Inet4Address;
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
        while (true){
            Socket socket = serverSocket.accept();
            InetAddress addr =  socket.getInetAddress();
            System.out.println("hostname:"+ addr.getHostName());
            System.out.println("getHostAddress:"+ addr.getHostAddress());
            System.out.println("getAddress:"+ addr.getAddress());
            System.out.println("getCanonicalHostName:"+ addr.getCanonicalHostName());

            System.out.println("接收到了");
        }


    }
}
