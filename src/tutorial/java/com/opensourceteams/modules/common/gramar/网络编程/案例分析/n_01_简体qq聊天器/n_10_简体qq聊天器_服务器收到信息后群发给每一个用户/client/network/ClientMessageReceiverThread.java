package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.client.network;




import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_09_简体qq聊天器_客户端通过发送按钮发送群信息.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_09_简体qq聊天器_客户端通过发送按钮发送群信息.model.ReaderMessage;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_09_简体qq聊天器_客户端通过发送按钮发送群信息.client.view.QQMainWindow;

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
               Object obj = readerMessage.objectDeserialize();
               Set<String> contractTableRowData = (Set<String>) obj;
               qqMainWindow.refleshContractTable(contractTableRowData);
           }

           System.out.println(count + "结束 客户端接收数据:");

       }
    }
}
