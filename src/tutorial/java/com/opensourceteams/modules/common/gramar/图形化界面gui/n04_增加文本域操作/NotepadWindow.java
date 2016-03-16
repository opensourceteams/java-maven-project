package com.opensourceteams.modules.common.gramar.图形化界面gui.n04_增加文本域操作;

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

    JButton btnOpen = new JButton("打开");

    JButton btnClose = new JButton("关闭");

    JButton btnSave = new JButton("保存");

    JTextArea tea = new JTextArea();


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



        btnOpen.setBounds( width /2 -100 -20 -100 ,250,100,50);

        btnClose.setBounds( width /2 -100 -10 ,250,100,50);

        btnSave.setBounds( width /2 +10 ,250,100,50);

        tea.setBounds(50,50,400,200);



        ButtonAdapt buttonAdapt = new ButtonAdapt();

        btnOpen.addMouseListener(buttonAdapt);

        btnClose.addMouseListener(buttonAdapt);

        btnSave.addMouseListener(buttonAdapt);




        this.add(btnOpen);
        this.add(btnClose);
        this.add(btnSave);

        this.add(tea);

    }

    class ButtonAdapt extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            Component component = e.getComponent();
            if(component == btnSave){
                System.out.println("单击了保存按钮");
            }else if(component == btnClose){
                System.out.println("单击了关闭按钮");
                System.exit(-1);

            }else if(component == btnOpen){
                System.out.println("单击了打开按钮");

            }
        }
    }
}
