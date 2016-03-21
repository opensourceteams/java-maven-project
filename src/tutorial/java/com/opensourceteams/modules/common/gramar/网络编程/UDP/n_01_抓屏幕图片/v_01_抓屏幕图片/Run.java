package com.opensourceteams.modules.common.gramar.网络编程.UDP.n_01_抓屏幕图片.v_01_抓屏幕图片;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午5:36
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(0,0,400,300);
        try {
            BufferedImage image =  new Robot().createScreenCapture(rect);

            System.out.println(image);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
