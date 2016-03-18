package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_10_简体qq聊天器_服务器收到信息后群发给每一个用户.model;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午2:38
 * 功能描述:
 */

public class ReaderMessageText extends Message {


    public ReaderMessageText(Message message){
        if(message!=null){

            super.setType(message.getType());
            super.setContent(message.getContent());
            super.setLength(message.getLength());
            super.setContentObject(message.getContentObject());

            if(message.getContentObject() != null){
                this.text = message.getContentObject().toString();
            }
        }



    }

    public ReaderMessageText(ReaderMessage readerMessage){
        if(readerMessage.getContentObject() != null){
            this.text = new String(readerMessage.getContentObject().toString());
        }

        super.setType(readerMessage.getType());
        super.setContent(readerMessage.getContent());
        super.setLength(readerMessage.getLength());
        super.setContentObject(readerMessage.getContentObject());

    }


    private String text;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
