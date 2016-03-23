package com.opensourceteams.modules.common.gramar.图形化界面gui.n_06_图片操作_抓屏功能.n_06_01_ImageIcon控件操作_在按钮中显示图片;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午9:59
 * 功能描述:
 */

public class MyJButtonImageIcon extends JFrame {

    JButton btnSave = null;

    ImageIcon imageIcon = new ImageIcon();

    public MyJButtonImageIcon(String title){
        init(title);
    }

    public void init(String title){

        this.setTitle(title);
        int x = 100 ;
        int y = 200 ;
        int width = 600 ;
        int height = 400;

        this.setLayout(null);

        this.setVisible(true);

        this.setLocation(x,y);//指定平面坐标

        this.setSize(width,height);//定义大小







        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("temp/screen_output.jpg"));
        } catch (IOException e) {
        }



        imageIcon.setImage(img);
        btnSave = new JButton(imageIcon);

        btnSave.setBounds( 0,0,400,300);




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
