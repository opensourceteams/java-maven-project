package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.client.network;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.model.WriterMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午4:21
 * 功能描述:
 */

public class ClientMessageSenderThread extends Thread {

    Socket socket;
    OutputStream os;
    Object object;
    byte type ;

    public ClientMessageSenderThread(Socket socket,Object object,byte type){
        this.socket = socket;
        this.object = object;
        this.type = type;

        try {
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        WriterMessage writerMessage = new WriterMessage(object,type);
        try {
            os.write(writerMessage.genMessagePack());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
