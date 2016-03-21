package com.opensourceteams.modules.common.gramar.图形化界面gui.n_01_jbutton按钮操作;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午9:59
 * 功能描述:
 */

public class MyJButton extends JFrame {

    JButton btnSave = new JButton("保存");

    public MyJButton(){
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




        btnSave.setBounds( width /2 +10 ,250,100,50);




        btnSave.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getComponent() == btnSave){
                    System.out.println("按钮单击事件");
                }

            }
        });




        this.add(btnSave);

    }
}
