package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.server;



import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.WriterMessage;

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

public class PushOnlineUserSetThread extends Thread {

    Socket socket = null;

    OutputStream os  = null;

    public PushOnlineUserSetThread(Socket socket) throws IOException {
        this.socket = socket;
        os = socket.getOutputStream();
    }

    @Override
    public void run() {

        byte[] readData = null;


        WriterMessage message = new WriterMessage(QQServer.getContractTableRowData());
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
