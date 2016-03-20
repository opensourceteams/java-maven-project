package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model;

import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;
import com.opensourceteams.modules.common.java.io.file.ObjectSerializationUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  下午5:15
 * 功能描述:
 */

public class ReaderMessage  extends com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model.Message {



    public ReaderMessage(InputStream is,int fileLengthByteLength){


        try {
            byte type = (byte) is.read();
            System.out.println(type);
            Vector<Byte> types = new Vector<Byte>();
            types.add(com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model.Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE);
            types.add(com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model.Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_CURRENT);
            types.add(com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model.Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_REFRESH);
            types.add(com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model.Message.DATA_TRANSFORM_TYPE_SERVER_PUSH_GROUP_MESSAGE_REFRESH);

            if(type == -1){
                setType((byte)-1); //读完,或客户端关了
                return ;
            }else if(!types.contains(type)){
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
            Object object = ObjectSerializationUtil.objectDeserialize(contentByteArray);

            if(object != null){
                setContentObject(object);
                setContent(contentByteArray);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            setType((byte)-1); //读完,或客户端关了
            return ;
        }
    }

    public ReaderMessage(InputStream is){
        this(is,4);
    }



}
