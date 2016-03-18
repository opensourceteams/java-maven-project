package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.client.network;




import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.model.ReaderMessageText;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.model.ReaderMessage;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_13_简体qq聊天器_客户端退出后_服务器在线用户刷新.client.view.QQMainWindow;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class ClientMessageReceiverThread extends Thread {

    Socket socket = null ;
    InputStream is = null ;
    QQMainWindow qqMainWindow = null ;

    public ClientMessageReceiverThread(Socket socket, QQMainWindow qqMainWindow){
        this.socket = socket;
        try {
            this.is = socket.getInputStream();
            this.qqMainWindow = qqMainWindow;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int count;
    @Override
    public void run() {

       while (true){
           System.out.println(++count + "客户端接收数据:");

           ReaderMessage readerMessage = new ReaderMessage(is);
           if(readerMessage.getType() == Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_CURRENT){
               System.out.println("客户端收到当前在线所有用户");
               Set<String> contractTableRowData = (Set<String>) readerMessage.getContentObject();
               qqMainWindow.refleshContractTable(contractTableRowData);
           }else if(readerMessage.getType() == Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_REFRESH){
               System.out.println("客户端收到当前在线所有用户刷新");
               Set<String> contractTableRowData = (Set<String>) readerMessage.getContentObject();
               qqMainWindow.refleshContractTable(contractTableRowData);
           }else if(readerMessage.getType() == Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_GROUP_MESSAGE_REFRESH){
               ReaderMessageText messageText = new ReaderMessageText(readerMessage);
               System.out.println("客户端接收到 --> 群消息 " + messageText.getText());

               qqMainWindow.appendJTextAreaHistory(messageText.getText());



           }


       }
    }
}
