package com.opensourceteams.modules.common.作业.第十九天.n_05_UDP通信传送图片;

import com.opensourceteams.modules.common.java.util.awt.ScreenCaptureUtil;
import com.opensourceteams.modules.common.java.util.net.UDPUtil;
import org.junit.Test;

import java.awt.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:56
 * 功能描述:
 */

public class UDPImageTest {

    @Test
    public void testReveive(){

        byte[] bytes = UDPUtil.reveiveOnce(8889);
        ScreenCaptureUtil.bytesToImageFile(bytes,"jpg","temp/screen_convert_output.jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
    }


    @Test
    public void testSender(){


        Rectangle rect = new Rectangle(0,0,800,300);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");

        UDPUtil.senderOnce(8889,"10.0.2.162",8888,bytes);
    }







}
