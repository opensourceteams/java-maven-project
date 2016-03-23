package com.opensourceteams.modules.common.gramar.网络编程.UDP.n_06_图片操作_抓屏功能.n_06_03_Button_Icon_按钮定时自动切换图片;

import com.opensourceteams.modules.common.java.algorithm.NextValueUtil;

import javax.swing.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午2:12
 * 功能描述:
 */

public class TaskThread extends Thread {


    long timeInterval = 1000;
    JButton btnShowImg ;
    int currentImgIndex = 0;
    String[] imgPaths;

    public TaskThread(JButton btnShowImg,String[] imgPaths){
        this.btnShowImg = btnShowImg;
        this.imgPaths = imgPaths;
    };

    public TaskThread(long timeInterval){
        this.timeInterval = timeInterval;
    };


    @Override
    public void run() {
        while (true){

            currentImgIndex = NextValueUtil.getNextValue(currentImgIndex,1);
            System.out.println("按钮切换图片:" +imgPaths[currentImgIndex]);
            btnShowImg.setIcon(new ImageIcon(imgPaths[currentImgIndex]));

            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
