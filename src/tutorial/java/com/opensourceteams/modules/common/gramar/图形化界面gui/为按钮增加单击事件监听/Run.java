package com.opensourceteams.modules.common.gramar.图形化界面gui.为按钮增加单击事件监听;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午12:03
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        JFrame  jFrame = new JFrame();
        jFrame.setLayout(null);

        jFrame.setVisible(true);

        jFrame.setLocation(100,200);//指定平面坐标

        jFrame.setSize(600,400);//定义大小

        Button button = new Button("保存");

        button.setBounds(150,250,100,50);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("单击了保存按钮");
            }
        });



        jFrame.add(button);

    }
}
