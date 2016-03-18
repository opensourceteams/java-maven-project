package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model;


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



}
