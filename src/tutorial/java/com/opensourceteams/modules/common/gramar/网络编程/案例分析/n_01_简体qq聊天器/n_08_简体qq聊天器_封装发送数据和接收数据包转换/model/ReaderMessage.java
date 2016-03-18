package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_08_简体qq聊天器_封装发送数据和接收数据包转换.model;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model.Message;
import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  下午5:15
 * 功能描述:
 */

public class ReaderMessage  extends Message {



    public ReaderMessage(InputStream is,int fileLengthByteLength){


        try {
            byte type = (byte) is.read();
            System.out.println(type);
            Vector<Byte> types = new Vector<Byte>();
            types.add(Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE);
            types.add(Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_CURRENT);
            types.add(Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_REFRESH);
            types.add(Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_GROUP_MESSAGE_REFRESH);

            if(!types.contains(type)){
                return ;
            }
            setType(type); //读取第一个byte 作为文件的类型

            byte[] contentLengthByteArray = new byte[fileLengthByteLength];

            int len = is.read(contentLengthByteArray); //读取四个byte作为文件的长度
            if(len != fileLengthByteLength){
                throw new Exception("length存储的4个byte有异常");
            }
            //文件长度,四个byte转换成 整形
            int length = IntConvertEachBinary.getIntByArray(contentLengthByteArray) ;
            setLength(length);

            //文件内容的缓冲数组
            byte[] contentByteArray = new byte[length];
            len = is.read(contentByteArray);

            if(len != length){
                throw new Exception("length存储的4个byte和长度和实际文件不符");
            }
            setContent(contentByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReaderMessage(InputStream is){
        this(is,4);
    }


    public Object objectDeserialize() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(super.getContent()));
            return  objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
