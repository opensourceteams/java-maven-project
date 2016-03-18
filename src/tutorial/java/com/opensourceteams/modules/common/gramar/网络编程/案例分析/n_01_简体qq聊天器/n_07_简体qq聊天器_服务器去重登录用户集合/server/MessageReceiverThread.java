package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.server;


import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class MessageReceiverThread extends Thread {

    Socket socket = null;

    public MessageReceiverThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("服务器接收");
        System.out.println("服务reader端:读取客户端数据-->" +"over");
    }
}
