package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.model;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午2:38
 * 功能描述:
 */

public class MessageText extends Message{


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
