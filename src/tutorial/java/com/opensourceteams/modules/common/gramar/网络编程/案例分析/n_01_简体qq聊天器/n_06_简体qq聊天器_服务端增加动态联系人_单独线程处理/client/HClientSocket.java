package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_06_简体qq聊天器_服务端增加动态联系人_单独线程处理.client;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_06_简体qq聊天器_服务端增加动态联系人_单独线程处理.client.network.ClientMessageReceiverThread;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_06_简体qq聊天器_服务端增加动态联系人_单独线程处理.view.QQMainWindow;
import com.opensourceteams.modules.common.java.io.file.FileBufferedUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午4:09
 * 功能描述:
 */

public class HClientSocket {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {


        QQMainWindow qqMainWindow = QQMainWindow.getInstance();

        String host = "192.168.12.2";
        host = "localhost";
        //host ="192.168.12.9";
        Socket socket = new Socket(host,1234);
        System.out.println("客户端发送请求...");

        ClientMessageReceiverThread clientMessageReceiverThread = new ClientMessageReceiverThread(socket,qqMainWindow);
        clientMessageReceiverThread.start();




        /**
         * 客户端写
         */
        BufferedWriter writer = null ;
        FileBufferedUtil.writerStringNoClose(writer,socket.getOutputStream(),"你好\r\n aa");



        /**
         * 客户端读
         */
     /*   InputStream is = socket.getInputStream();
        int fileType = is.read();
        if(fileType == 1){
            byte[] fileLengthByte = new byte[4];

            int len = is.read(fileLengthByte);

            int fileLength = IntConvertEachBinary.getIntByArray(fileLengthByte);
            byte[] fileContentByte = new byte[fileLength];
            len = is.read(fileContentByte);

            Vector<Vector> contractTableRowData = (Vector<Vector>) ObjectSerializationUtil.objectDeserialize(fileContentByte);


            qqMainWindow.refleshContractTable3(contractTableRowData);
        }

*/


/*        if(writer!= null){
            writer.close();
        }*/



        System.out.println("over");


    }
}
