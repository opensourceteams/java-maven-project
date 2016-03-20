package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.model;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.model.*;
import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;
import com.opensourceteams.modules.common.java.io.file.ObjectSerializationUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  下午4:45
 * 功能描述:输出消息
 * 封装类,只要传对象数据,直接构建报文传输格式
 示例 :

 Object obj = New Object; //为任意类形数据
 WriterMessage message = new WriterMessage(Objt);
 message.getContent(); //得到byte[] 内容数据
 message.genMessagePack(); //生成自定义报文传输格式

 */

public class WriterMessage extends com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_15_简体qq聊天器_增加客户端HostName显示.model.Message {







    public WriterMessage(Object obj,byte type){

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            super.setType(type);
            super.setContent(byteArray);
            super.setLength(byteArray.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    /**
     * 生成报文
     * 第一个byte 是文件类型 1:文本
     * 第二个byte到第五个byte,共4个byte表示文件的长度
     * 第三个部分,是文件的数据
     * @return
     */
    public  byte[] genMessagePack(){
        byte[] dataArray = new byte[ 1 + 4 + getLength()];

        byte[] lengtyArray = IntConvertEachBinary.convertIntToByteArry(super.getLength());

        dataArray[0] = getType() ;

        System.arraycopy(lengtyArray,0,dataArray,1,4);
        System.arraycopy(getContent(),0,dataArray,5,super.getLength());

        return dataArray;
    }
}
