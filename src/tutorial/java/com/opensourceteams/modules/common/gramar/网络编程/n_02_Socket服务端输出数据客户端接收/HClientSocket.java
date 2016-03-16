package com.opensourceteams.modules.common.gramar.网络编程.n_02_Socket服务端输出数据客户端接收;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        host ="192.168.12.9";
        Socket socket = new Socket(host,1234);
        System.out.println("客户端发送请求...");

        BufferedReader buffer = null;

        buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("服务器返回的数据 : " + buffer.readLine());

        buffer.close();
        socket.close();
    }
}
