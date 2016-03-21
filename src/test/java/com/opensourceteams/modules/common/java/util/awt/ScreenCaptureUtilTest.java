package com.opensourceteams.modules.common.java.util.awt;

import org.junit.Test;

import java.awt.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:34
 * 功能描述:
 */

public class ScreenCaptureUtilTest {

    /**
     * 抓屏幕存储为指定路径的图片
     */
    @Test
    public void testScreenCaptureToImageFile(){
        Rectangle rect = new Rectangle(0,0,600,500);
        ScreenCaptureUtil.screenCaptureToImageFile(rect,"jpg","temp/screen_output.jpg");
    }

    /**
     * 抓取屏幕数据,返回byte数组
     */
    @Test
    public void testScreenCaptureToBytes(){
        Rectangle rect = new Rectangle(0,0,400,300);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
    }

    /**
     * 将byte数组,转换为图片文件
     */
    @Test
    public void testBytesToImageFile(){
        Rectangle rect = new Rectangle(0,0,400,300);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");

        ScreenCaptureUtil.bytesToImageFile(bytes,"jpg","temp/screen_convert_output.jpg");
    }



}
