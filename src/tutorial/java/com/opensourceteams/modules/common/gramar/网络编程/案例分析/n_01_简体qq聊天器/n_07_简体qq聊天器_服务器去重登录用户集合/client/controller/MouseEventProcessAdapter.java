package com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.client.controller;

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

    public MouseEventProcessAdapter(JButton btnSend){
        this.btnSend = btnSend ;
    };

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() == btnSend){
            System.out.println("单击事件");
        }
    }
}
