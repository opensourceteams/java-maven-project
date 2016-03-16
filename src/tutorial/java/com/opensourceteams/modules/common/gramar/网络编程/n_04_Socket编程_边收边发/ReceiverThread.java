package com.opensourceteams.modules.common.gramar.网络编程.n_04_Socket编程_边收边发;

import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class ReceiverThread extends Thread {

    Socket socket = null;

    public ReceiverThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        String readData = null;
        BufferedReader reader  = null;
        try {
            readData = FileBufferedUtil.readerStringBuilderNoClose(reader,socket.getInputStream()).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服客reader端:读取客户端数据-->" +readData);
    }
}
