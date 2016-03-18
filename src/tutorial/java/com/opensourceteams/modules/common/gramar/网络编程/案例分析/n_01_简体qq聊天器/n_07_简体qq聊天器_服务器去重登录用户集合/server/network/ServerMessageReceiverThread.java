package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.server.network;


import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.MessageText;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.ReaderMessage;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class ServerMessageReceiverThread extends Thread {

    Socket socket = null;

    InputStream is = null;

    int count;
    public ServerMessageReceiverThread(Socket socket){
        this.socket = socket;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String receiveData = "";
        while (true){


            Message message = new ReaderMessage(is);
            if(message.getType() == Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE){

                MessageText messageText = new MessageText(message);
                receiveData = messageText.getText();

            }


            System.out.println(++count + "服务reader端:读取客户端数据-->" +receiveData);


        }

    }
}
