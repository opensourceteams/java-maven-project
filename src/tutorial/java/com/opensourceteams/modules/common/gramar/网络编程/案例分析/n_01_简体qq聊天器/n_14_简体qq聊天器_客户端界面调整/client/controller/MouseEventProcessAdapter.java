package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.client.controller;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.model.Message;
import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_14_简体qq聊天器_客户端界面调整.common.network.CommonMessageSenderThread;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午2:00
 * 功能描述:
 */

public class MouseEventProcessAdapter extends MouseAdapter {

    JButton btnSend;
    JTextArea taContent;
    Socket socket;

    public MouseEventProcessAdapter(JButton btnSend,JTextArea taContent,Socket socket){
        this.btnSend = btnSend ;
        this.taContent = taContent;
        this.socket = socket;
    };

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() == btnSend){
            System.out.println("单击事件" + taContent.getText());
            String text = taContent.getText();
            new CommonMessageSenderThread(socket,text, Message.DATA_TRANSFORM_TYPE_CLIENT_SEND_MESSAGE).start();
            taContent.setText("");
        }
    }
}
