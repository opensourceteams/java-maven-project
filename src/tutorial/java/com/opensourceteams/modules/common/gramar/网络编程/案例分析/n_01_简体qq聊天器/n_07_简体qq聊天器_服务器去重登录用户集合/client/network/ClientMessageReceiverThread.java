package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.client.network;




import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.ReaderMessage;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.view.QQMainWindow;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Set;
import java.util.Vector;

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

    @Override
    public void run() {
       while (true){

           ReaderMessage readerMessage = new ReaderMessage(is);
           if(readerMessage.getType() == (byte)1){
               Object obj = readerMessage.objectDeserialize();
               Set<String> contractTableRowData = (Set<String>) obj;
               qqMainWindow.refleshContractTable3(contractTableRowData);
           }

       /* int fileType = 0;
          try {

               fileType = is.read();

               if(fileType == 1){
                   byte[] fileLengthByte = new byte[4];

                   int len = is.read(fileLengthByte);

                   int fileLength = IntConvertEachBinary.getIntByArray(fileLengthByte);
                   byte[] fileContentByte = new byte[fileLength];
                   len = is.read(fileContentByte);

                   Vector<Vector> contractTableRowData = (Vector<Vector>) ObjectSerializationUtil.objectDeserialize(fileContentByte);


                   qqMainWindow.refleshContractTable3(contractTableRowData);
               }


           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
*/

       }
    }
}
