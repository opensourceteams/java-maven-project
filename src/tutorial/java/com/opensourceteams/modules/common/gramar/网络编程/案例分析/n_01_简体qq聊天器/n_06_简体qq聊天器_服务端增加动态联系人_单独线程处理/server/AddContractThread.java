package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_06_简体qq聊天器_服务端增加动态联系人_单独线程处理.server;


import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  上午8:39
 * 功能描述:单独处理增加联系人的线程
 */

public class AddContractThread extends Thread{

    private Socket socket;
    public AddContractThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {

        QQServer.addContractTableRowData(socket.getInetAddress().getHostName());
    }
}
