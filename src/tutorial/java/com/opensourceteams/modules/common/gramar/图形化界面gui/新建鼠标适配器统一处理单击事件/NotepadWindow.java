package com.opensourceteams.modules.common.gramar.图形化界面gui.新建鼠标适配器统一处理单击事件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午2:26
 * 功能描述:
 */

public class NotepadWindow extends  JFrame{

    Button btnSave = new Button("保存");

    Button btnClose = new Button("关闭");


    public NotepadWindow(){
        init();
    }

    public void init(){

        int x = 100 ;
        int y = 200 ;
        int width = 600 ;
        int height = 400;

        this.setLayout(null);

        this.setVisible(true);

        this.setLocation(x,y);//指定平面坐标

        this.setSize(width,height);//定义大小



        btnClose.setBounds(150 ,250,100,50);

        btnSave.setBounds( width /2 +10 ,250,100,50);



        ButtonAdapt buttonAdapt = new ButtonAdapt();

        btnSave.addMouseListener(buttonAdapt);

        btnClose.addMouseListener(buttonAdapt);



        this.add(btnSave);
        this.add(btnClose);

    }

    class ButtonAdapt extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            Component component = e.getComponent();
            if(component == btnSave){
                System.out.println("单击了保存按钮");
            }else if(component == btnClose){
                System.out.println("单击了关闭按钮");
            }
        }
    }
}
