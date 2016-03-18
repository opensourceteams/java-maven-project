package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_08_简体qq聊天器_封装发送数据和接收数据包转换.server.network;



import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.WriterMessage;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.server.QQServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class ServerMessageSenderThread extends Thread {

    Socket socket = null;

    OutputStream os  = null;

    public ServerMessageSenderThread(Socket socket) throws IOException {
        this.socket = socket;
        os = socket.getOutputStream();
    }

    @Override
    public void run() {

        byte[] readData = null;


        WriterMessage message = new WriterMessage(QQServer.getContractTableRowData());
        try {
            readData = message.getContent();
            os.write(message.genMessagePack());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("服务writer端:读取客户端数据-->" +new String(readData));
    }
}
