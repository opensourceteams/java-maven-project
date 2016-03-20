package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.client.app;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.client.network.ClientMessageReceiverThread;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.client.view.QQMainWindow;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.common.network.CommunicationUtil;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.model.Message;

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




        QQMainWindow qqMainWindow = QQMainWindow.getInstance("192.168.12.1");
        Socket socket = qqMainWindow.getSocket();


        /**
         * 单独线程,循环读消息
         */
        ClientMessageReceiverThread clientMessageReceiverThread = new ClientMessageReceiverThread(socket,qqMainWindow);
        clientMessageReceiverThread.start();









        /**
         * 客户端写
         */

   /*     WriterMessage message = new WriterMessage("你好", Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_GROUP_MESSAGE);

        socket.getOutputStream().write(message.genMessagePack());


*/


        System.out.println("客户端结束");


    }
}
