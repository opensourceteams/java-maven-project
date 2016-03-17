package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_04_简体qq聊天器_增加动态联系人_更新新连进来的客户端.server;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_04_简体qq聊天器_增加动态联系人_更新新连进来的客户端.model.WriterMessage;
import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;
import com.opensourceteams.modules.common.java.io.file.ObjectSerializationUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午6:40
 * 功能描述:
 */

public class MessageSenderThread extends Thread {

    Socket socket = null;

    OutputStream os  = null;
    Vector<Vector> contractTableRowData;

    public MessageSenderThread(Socket socket,Vector<Vector> contractTableRowData) throws IOException {
        this.socket = socket;
        this.contractTableRowData = contractTableRowData ;
        os = socket.getOutputStream();
    }

    @Override
    public void run() {

        byte[] readData = null;


        WriterMessage message = new WriterMessage(contractTableRowData);
        try {
            readData = message.getContent();
            os.write(message.genMessagePack());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }




      /*  try {
            readData = ObjectSerializationUtil.objectSerialization(contractTableRowData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Byte> resultList = new ArrayList<Byte>();
        resultList.add((byte) 1);

        byte[] writeLengthByte = IntConvertEachBinary.convertIntToByteArry(readData.length);

        for(byte b : writeLengthByte){
            resultList.add(b);
        }

        for(byte b : readData){
            resultList.add(b);
        }

        resultList.toArray();

        byte[] resultByteArray = new byte[resultList.size()];

        for(int i = 0;i< resultList.size();i++){
            resultByteArray[i] = resultList.get(i);
        }




        try {
            os.write(resultByteArray);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("服务writer端:读取客户端数据-->" +new String(readData));
    }
}
