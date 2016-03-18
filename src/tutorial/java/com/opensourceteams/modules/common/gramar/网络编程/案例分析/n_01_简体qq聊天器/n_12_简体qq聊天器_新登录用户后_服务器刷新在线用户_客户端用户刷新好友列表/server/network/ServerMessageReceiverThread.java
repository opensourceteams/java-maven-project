package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.server.network;



import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.model.ReaderMessageText;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.model.ReaderMessage;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_12_简体qq聊天器_新登录用户后_服务器刷新在线用户_客户端用户刷新好友列表.server.service.QQServerService;
import com.opensourceteams.modules.common.java.util.CalendarUtil;

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

    QQServerService qqServerService = new QQServerService();

    @Override
    public void run() {
        Object receiveData = "";
        while (true){


            Message message = new ReaderMessage(is);
            if(message.isOfEnd()){
                break;
            }else if(message.getType() == Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE){

                ReaderMessageText messageText = new ReaderMessageText(message);
                receiveData = messageText.getText();
                //重新组装发送信息
                StringBuffer sb = new StringBuffer();
                sb.append("\r\n");
                sb.append(socket.getInetAddress().getHostAddress() );
                sb.append("\t");
                sb.append(CalendarUtil.getSimpleDate());
                sb.append("\r\n");
                sb.append(messageText.getText());




                qqServerService.pushGroupMessageToAllUser(new Message(sb.toString()));


            }


            System.out.println(++count + "服务reader端:读取客户端数据-->" +receiveData);


        }

    }
}
