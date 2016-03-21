package com.opensourceteams.modules.common.java.util.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:29
 * 功能描述:
 */

public class ScreenCaptureUtil {

    /**
     * 抓屏幕存储为指定路径的图片
     * @param rect
     * @param imageType
     * @param imageFilePath
     * @return
     调用示例:
        Rectangle rect = new Rectangle(0,0,400,300);
        ScreenCaptureUtil.screenCaptureToImageFile(rect,"jpg","temp/screen_output.jpg");
     */
    public static boolean screenCaptureToImageFile(Rectangle rect,String imageType,String imageFilePath){
        //创建屏幕的抓图区域
        //Rectangle rect = new Rectangle(0, 0, 600, 400);

        //通过Robot对象抓图，返回BufferedImage对象
        BufferedImage image = null;
        boolean result = true;
        try {
            image = new Robot().createScreenCapture(rect);
            System.out.println(image);
            try {
                ImageIO.write(image, imageType, new FileOutputStream(imageFilePath));

            } catch (IOException e) {
                e.printStackTrace();
                result = false;
            }
        } catch (AWTException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }


    /**
     * 抓取屏幕数据,返回byte数组
     * @param rect
     * @param imageType
     * @return
     调用示例:
        Rectangle rect = new Rectangle(0,0,400,300);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
     */
    public static byte[] screenCaptureToBytes(Rectangle rect,String imageType){

        //通过Robot对象抓图，返回BufferedImage对象
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(rect);
            //System.out.println(image);
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, imageType, baos);

                byte[] bytes = baos.toByteArray();

                return bytes;

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将byte数组,转换为图片文件
     * @param bytes
     * @param fileType
     * @param fileOutputPath
     * @return
     * 示例:

        Rectangle rect = new Rectangle(0,0,400,300);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");

        ScreenCaptureUtil.bytesToImageFile(bytes,"jpg","temp/screen_convert_output.jpg");
     */
    public static boolean bytesToImageFile(byte[] bytes ,String fileType,String fileOutputPath){
        if(bytes == null){
            return false ;
        }

        boolean result = true;
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIO.write(image, fileType, new FileOutputStream(fileOutputPath));
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }

        return result;

    }
}
