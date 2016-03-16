package com.opensourceteams.modules.common.gramar.网络编程.n_01_Socket编程开启一个服务和一个客户端;

import java.io.IOException;
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
        Socket socket = new Socket(host,1234);
        System.out.println("客户端");
    }
}
