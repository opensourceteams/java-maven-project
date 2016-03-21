package com.opensourceteams.modules.common.gramar.图形化界面gui.n_06_图片操作.n_06_04_Button_Icon_按钮定时自动接收UDP图片包更新图片;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午9:59
 * 功能描述:
 */

public class MyJButtonImageIcon extends JFrame {

    MyJButtonImageIcon instance = null;

    JButton btnShowImg = null;

    ImageIcon imageIcon = new ImageIcon();

    JButton btnChange = new JButton("切换图片");

    //图片
    BufferedImage img = null;

    String[] imgPaths = {"temp/screen_output_0_0_400_300.jpg","temp/screen_output_300_200_400_300.jpg"};



    public MyJButtonImageIcon(String title){
        init(title);
    }

    public void init(String title){

        instance = this;
        this.setTitle(title);
        int x = 100 ;
        int y = 200 ;
        int width = 600 ;
        int height = 400;

        this.setLayout(null);

        this.setVisible(true);

        this.setLocation(x,y);//指定平面坐标

        this.setSize(width,height);//定义大小








        //图片按钮
        btnShowImg = new JButton();
        btnShowImg.setIcon(new ImageIcon(imgPaths[0]));

        btnShowImg.setBounds( 0,0,400,300);








        //切换图片的按钮
        btnChange.setBounds(0,310,100,50);


        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8889);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        new TaskThread(btnShowImg,socket).start();






        this.add(btnShowImg);
        this.add(btnChange);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户单击“关闭”按钮时关闭窗口
        this.setVisible(true);

    }
}
