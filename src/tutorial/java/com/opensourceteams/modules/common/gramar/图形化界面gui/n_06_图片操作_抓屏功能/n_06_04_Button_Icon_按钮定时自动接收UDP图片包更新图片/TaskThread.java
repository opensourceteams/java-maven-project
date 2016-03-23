package com.opensourceteams.modules.common.gramar.图形化界面gui.n_06_图片操作_抓屏功能.n_06_04_Button_Icon_按钮定时自动接收UDP图片包更新图片;

import com.opensourceteams.modules.common.java.util.net.UDPUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramSocket;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午2:12
 * 功能描述:
 */

public class TaskThread extends Thread {


    long timeInterval = 1000;
    JButton btnShowImg ;
    DatagramSocket socket ;


    public TaskThread(JButton btnShowImg,DatagramSocket socket){
        this.btnShowImg = btnShowImg;
        this.socket = socket;
    };

    public TaskThread(long timeInterval){
        this.timeInterval = timeInterval;
    };


    @Override
    public void run() {
        while (true){





            BufferedImage bufferedImage = null;
            try {
                byte[] bytes = UDPUtil.reveive(socket);
                ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                bufferedImage = ImageIO.read(bais);
                //bufferedImage = ImageIO.read(new File("temp/screen_convert_output_21.jpg"));
                btnShowImg.setIcon(new ImageIcon(bufferedImage,""));
            } catch (IOException e) {
                e.printStackTrace();
            }



            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
