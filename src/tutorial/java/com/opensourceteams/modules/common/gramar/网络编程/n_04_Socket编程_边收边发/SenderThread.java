package com.opensourceteams.modules.common.gramar.网络编程.n_04_Socket编程_边收边发;


import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午9:34
 * 功能描述:
 */

public class SenderThread extends Thread {

    Socket socket = null;


    public SenderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
/*        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            writer.write("返回的数据");
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        BufferedWriter writer = null ;
        try {
            FileBufferedUtil.writerStringNoClose(writer,socket.getOutputStream(),"服务器写端返回数据\r\n 内容...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
