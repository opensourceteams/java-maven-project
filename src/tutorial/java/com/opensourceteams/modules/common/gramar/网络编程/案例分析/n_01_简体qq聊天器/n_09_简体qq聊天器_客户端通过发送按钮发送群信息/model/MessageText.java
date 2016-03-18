package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_09_简体qq聊天器_客户端通过发送按钮发送群信息.model;


/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午2:38
 * 功能描述:
 */

public class MessageText extends Message {


    public MessageText(Message message){
        this.text = new String(message.getContent());
        super.setType(message.getType());
        super.setContent(message.getContent());
        super.setLength(message.getLength());

    }


    private String text;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
