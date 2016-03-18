package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_08_简体qq聊天器_封装发送数据和接收数据包转换.client.controller;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午2:00
 * 功能描述:
 */

public class MouseEventProcessAdapter extends MouseAdapter {

    JButton btnSend;
    JTextArea taContent;

    public MouseEventProcessAdapter(JButton btnSend,JTextArea taContent){
        this.btnSend = btnSend ;
        this.taContent = taContent;
    };

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() == btnSend){
            System.out.println("单击事件" + taContent.getText());
        }
    }
}
