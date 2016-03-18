package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.server.network;



import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model.WriterMessage;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.server.QQServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:推送在线用户集合给 当前登录的用户
 * ).需要单独推送,因为是一个及时的过程,用户一登录,就需要更新所有在线用户
 * ).新登录用户时,要推送所有用户集合给每一个用户,这个操作大,优先级,实时性要求低些,所以可以相对zhi后,所以可以和上面情况分离
 */

public class ServerPushOnlineUserSetThread extends Thread {

    Socket socket = null;

    OutputStream os  = null;

    public ServerPushOnlineUserSetThread(Socket socket) throws IOException {
        this.socket = socket;
        os = socket.getOutputStream();
    }

    @Override
    public void run() {

        byte[] readData = null;


        WriterMessage message = new WriterMessage(QQServer.getContractTableRowData(), Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_CURRENT);
        try {
            readData = message.getContent();
            os.write(message.genMessagePack());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("服务writer端:读取客户端数据-->" +new String(readData));
    }
}
