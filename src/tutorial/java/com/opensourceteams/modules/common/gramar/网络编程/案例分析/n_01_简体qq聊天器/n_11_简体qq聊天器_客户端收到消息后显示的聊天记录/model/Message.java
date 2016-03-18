package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_11_简体qq聊天器_客户端收到消息后显示的聊天记录.model;


import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/17  下午4:45
 * 功能描述:输出消息
 */

public class Message {

    /**
     * 服务器向客户端主动推送,当前在线用户列表
     */
    public static  byte  DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_CURRENT = 1;

    /**
     * 服向器向客户端主动推送,当前在线用户列表更新
     */
    public static  byte  DATA_TRANSFORM_TYPE_SERVER_PUSH_USERSET_REFRESH = 2;

    /**
     * 客户端用户向群发送消息,群消息
     */
    public static  byte  DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE = 3;


    /**
     * 服向器向客户端主动推送,当前群更新消息
     */
    public static  byte  DATA_TRANSFORM_TYPE_SERVER_PUSH_GROUP_MESSAGE_REFRESH = 4;



    private byte type;
    private int length;
    private byte[] content;
    private Object contentObject;



    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
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

        byte[] lengtyArray = IntConvertEachBinary.convertIntToByteArry(getLength());

        dataArray[0] = getType() ;

        System.arraycopy(lengtyArray,0,dataArray,1,4);
        System.arraycopy(getContent(),0,dataArray,5,getLength());

        return dataArray;
    }

    public Object getContentObject() {
        return contentObject;
    }

    public void setContentObject(Object contentObject) {
        this.contentObject = contentObject;
    }
}
