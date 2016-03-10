package com.opensourceteams.modeles.common.gramar.网络编程;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午10:18
 * 功能描述:
 */

public class MySocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket client = null;

        PrintStream output = null;
        server = new ServerSocket(9999);
        System.out.println("server:" );
        client = server.accept();
        output = new PrintStream(client.getOutputStream());
        output.println("this server print info");

        output.close();
        client.close();
        server.close();
    }
}
