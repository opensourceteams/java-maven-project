package com.opensourceteams.modules.common.gramar.网络编程.n_04_Socket编程_边收边发;

import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:10
 * 功能描述:
 */

public class HServerSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);


        Socket socket = null;

        BufferedReader reader = null;
        BufferedWriter writer = null;



        String readData = "";


        System.out.println("服务已启动,端口为:" +serverSocket.getLocalPort() + " ...... ");
        char[] buffer = new char[1024];
        int len = 0 ;
        while (true){
            socket = serverSocket.accept();
            InetAddress addr =  socket.getInetAddress();

            System.out.println("接收到了,客户端请求:" + addr.getHostName());

            //reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8")) ;

            new ReceiverThread(socket).start();
            new SenderThread(socket).start();
            //len = reader.read(buffer);
            //readData = readData + new String(buffer,0,len);
            //readData = FileBufferedUtil.readerStringBuilderNoClose(socket.getInputStream(),buffer).toString();


           // readData = reader.readLine();
            //readData = readData +reader.readLine();

            //readData = FileBufferedUtil.readerStringBuilderNoClose(reader,socket.getInputStream()).toString();
           // System.out.println("服客reader端:读取客户端数据-->" +readData);

           // reader.close();

  /*          writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            writer.write("服务端处理后返回-->");
            writer.newLine();
            writer.flush();*/
            //writer.close();

           // socket.close();
        }


    }
}
