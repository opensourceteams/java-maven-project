package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.server.service;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.common.network.CommonMessageSenderThread;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.model.ReaderMessageText;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.server.control.QQServer;
import com.opensourceteams.modules.common.java.util.SetUtil;

import java.net.Socket;
import java.util.List;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午5:19
 * 功能描述:
 */

public class QQServerService {


    /**
     * 推送群消息给每一个登录的用户
     * @return
     */
    public boolean pushGroupMessageToAllUser(Message message){


        List<Socket> socketList = QQServer.getSocketList();
        for (Socket socket : socketList){

            System.out.println("服务器 --> 发送群消息给每一个登录的用户: " + socket.getInetAddress().getHostAddress() );
            System.out.println(new ReaderMessageText(message).getText());
           new CommonMessageSenderThread(socket,new ReaderMessageText(message).getText(), Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_GROUP_MESSAGE_REFRESH).start();

        }

        return  true;

    }

    /**
     * 推送刷新用户给所有人,即当有新的用户登录后,把登录用户刷新给所有人
     * @return
     */
    public boolean pushRefreshUsersToAllUser(Socket socket){

        //刷新服务器,在线用户信息
        refreshAddUserToUsersSet(socket);

        Set<String> users = QQServer.getContractTableRowData();
        List<Socket> socketList = QQServer.getSocketList();
        for (Socket subSocket : socketList){

            System.out.println("服务器 --> 推送刷新用户给所有人: " + subSocket.getInetAddress().getHostAddress() );
            System.out.println(users);
            new CommonMessageSenderThread(subSocket,users, Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_REFRESH).start();

        }
        return true;
    }


    public synchronized boolean  refreshAddUserToUsersSet(Socket socket){
        Set<String> users = QQServer.getContractTableRowData();
        users.add(socket.getInetAddress().getHostAddress()) ;
        System.out.println("增加登录用户后,服务端的数据begin");
        SetUtil.println(users);
        System.out.println("原来的");
        SetUtil.println(QQServer.getContractTableRowData());
        System.out.println("增加登录用户后,服务端的数据end");
        return true;
    }


}
