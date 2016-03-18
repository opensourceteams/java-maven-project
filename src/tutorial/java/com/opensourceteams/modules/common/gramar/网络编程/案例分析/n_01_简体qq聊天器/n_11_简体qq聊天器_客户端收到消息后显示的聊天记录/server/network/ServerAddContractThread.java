package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.server.network;



import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.server.control.QQServer;

import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  上午8:39
 * 功能描述:单独处理增加联系人的线程
 */

public class ServerAddContractThread extends Thread{

    private Socket socket;
    public ServerAddContractThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {

        QQServer.addContractTableRowData(socket.getInetAddress().getHostAddress());
    }
}
