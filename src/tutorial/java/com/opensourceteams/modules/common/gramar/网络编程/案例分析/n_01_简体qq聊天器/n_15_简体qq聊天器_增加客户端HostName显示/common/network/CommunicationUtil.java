package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.common.network;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.model.Message;

import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  上午6:21
 * 功能描述: 通信类
 * 可以调用,发送消息,接收消息
 */

public class CommunicationUtil {


    /**
     * 发送消息,异步的,相当于多线程
     * @param socket
     * @param sendContent
     * @param sendType
     * @return
     */
    public static boolean sendMessageAsynchronous(Socket socket,Object sendContent,byte sendType){
        new CommonMessageSenderThread(socket,sendContent, sendType).start();
        return  true;
    }

    /**
     * 发送消息,同步的,相当于单线程,阻sai的
     * @param socket
     * @param sendContent
     * @param sendType
     * @return
     */
    public static boolean sendMessageNonsynchronous(Socket socket,Object sendContent,byte sendType){
        new CommonMessageSender(socket,sendContent, sendType).send();
        return  true;
    }
}
