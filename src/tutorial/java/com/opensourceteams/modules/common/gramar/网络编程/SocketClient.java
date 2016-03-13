package com.opensourceteams.modules.common.gramar.网络编程;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午10:29
 * 功能描述:
 */

public class SocketClient {


    public static void main(String[] args) throws Exception {
        Socket client = null;
        client = new Socket("localhost",9999);
        BufferedReader buffer = null;

        buffer = new BufferedReader(new InputStreamReader(client.getInputStream()));

        System.out.println("The content from server is : " + buffer.readLine());

        buffer.close();
        client.close();
    }
}
