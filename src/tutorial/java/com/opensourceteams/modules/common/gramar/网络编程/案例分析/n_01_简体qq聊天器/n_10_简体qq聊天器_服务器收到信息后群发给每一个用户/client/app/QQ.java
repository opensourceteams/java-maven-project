package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.client.app;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.client.network.ClientMessageReceiverThread;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.client.view.QQMainWindow;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model.WriterMessage;

import java.io.IOException;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:09
 * 功能描述:
 */

public class QQ {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {



        System.out.println("客户端发送请求...");


        QQMainWindow qqMainWindow = QQMainWindow.getInstance();
        Socket socket = qqMainWindow.getSocket();


        ClientMessageReceiverThread clientMessageReceiverThread = new ClientMessageReceiverThread(socket,qqMainWindow);
        clientMessageReceiverThread.start();




        /**
         * 客户端写
         */

        WriterMessage message = new WriterMessage("你好", Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE);

        socket.getOutputStream().write(message.genMessagePack());





        System.out.println("客户端结束");


    }
}
