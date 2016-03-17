package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_03_简体qq聊天器_增加动态联系人.server;

import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class MessageReceiverThread extends Thread {

    Socket socket = null;

    public MessageReceiverThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        String readData = null;
        BufferedReader reader  = null;
        try {
            Vector<String> contract =new Vector();
            contract.add("小军");
            QQServer.addContractTableRowData(contract);
            readData = FileBufferedUtil.readerStringBuilderNoClose(reader,socket.getInputStream()).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务reader端:读取客户端数据-->" +readData);
    }
}
