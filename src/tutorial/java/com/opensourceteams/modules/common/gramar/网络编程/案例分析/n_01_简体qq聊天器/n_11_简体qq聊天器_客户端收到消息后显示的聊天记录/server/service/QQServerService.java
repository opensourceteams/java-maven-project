package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.server.service;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.client.network.ClientMessageSenderThread;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model.ReaderMessageText;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.server.QQServer;

import java.net.Socket;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午5:19
 * 功能描述:
 */

public class QQServerService {


    /**
     * 发送群消息给每一个登录的用户
     * @return
     */
    public boolean sendMessageAllUser(Message message){



        List<Socket> socketList = QQServer.getSocketList();
        for (Socket socket : socketList){

            System.out.println("服务器 --> 发送群消息给每一个登录的用户: " + socket.getInetAddress().getHostAddress() );
            System.out.println(new ReaderMessageText(message).getText());
           new ClientMessageSenderThread(socket,new ReaderMessageText(message).getText(), Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_GROUP_MESSAGE_REFRESH).start();

        }

        return  true;

    }
}
