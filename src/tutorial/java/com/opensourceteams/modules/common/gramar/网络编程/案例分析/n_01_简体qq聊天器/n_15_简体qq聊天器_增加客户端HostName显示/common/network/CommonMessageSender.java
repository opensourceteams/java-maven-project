package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.common.network;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.model.WriterMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午4:21
 * 功能描述:
 */

public class CommonMessageSender {

    Socket socket;
    OutputStream os;
    Object object;
    byte type ;

    public CommonMessageSender(Socket socket, Object object, byte type){
        this.socket = socket;
        this.object = object;
        this.type = type;

        try {
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send() {
        WriterMessage writerMessage = new WriterMessage(object,type);
        try {
            os.write(writerMessage.genMessagePack());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
