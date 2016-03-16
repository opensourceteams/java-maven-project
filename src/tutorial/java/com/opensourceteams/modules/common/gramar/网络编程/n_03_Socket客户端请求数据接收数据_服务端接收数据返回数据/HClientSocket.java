package com.opensourceteams.modules.common.gramar.网络编程.n_03_Socket客户端请求数据接收数据_服务端接收数据返回数据;

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
        host ="192.168.12.9";
        Socket socket = new Socket(host,1234);
        System.out.println("客户端发送请求...");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

        writer.write(" hello java");
        writer.newLine();

        writer.flush();


        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("服务器返回的数据 : " + reader.readLine());

        writer.close();
        reader.close();

        socket.close();
    }
}
