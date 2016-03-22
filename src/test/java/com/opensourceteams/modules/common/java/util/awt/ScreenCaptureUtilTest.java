package com.opensourceteams.modules.common.java.util.awt;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.util.zip.ZipUtil;
import org.junit.Test;

import java.awt.*;
import java.util.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:34
 * 功能描述:
 */

public class ScreenCaptureUtilTest {

    /**
     * 抓屏幕存储为指定路径的图片
     * 客户端宽:1680
     客户端高:1050
     */
    @Test
    public void testScreenCaptureToImageFile(){
        Rectangle rect = new Rectangle(0,0,1680,1050);
        ScreenCaptureUtil.screenCaptureToImageFile(rect,"jpg","temp/screen_output.jpg");
    }

    /**
     * 抓取屏幕数据,返回byte数组
     */
    @Test
    public void testScreenCaptureToBytes(){
        Rectangle rect = new Rectangle(0,0,1680,1050);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
    }

    /**
     * 抓取屏幕数据,返回byte数组,拆包
     */
    @Test
    public void testScreenCaptureToBytesAndSplitPack(){
        Rectangle rect = new Rectangle(0,0,1680,1050);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.println("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
        java.util.List<byte[]> list  = SplitArrayUtil.splitArray(bytes,1024 * 50, (byte) 1);
        for (byte[] sub : list){

            byte type = SplitArrayUtil.getSplitValue(sub[0])[0];
            byte currentCount = SplitArrayUtil.getSplitValue(sub[0])[1];
            byte totalCount = sub[1];
            System.out.println("包类型" +type +" 当前包数:" + currentCount +" 总包数:" + totalCount +" 每个包的长度:" +sub.length + "  -->" + (sub.length / 1024) + "(KB)");
        }
    }

    /**
     * 抓取屏幕数据,返回byte数组,并压缩
     */
    @Test
    public void test_4_ScreenCaptureToBytesAndGzipCompress(){
        Rectangle rect = new Rectangle(0,0,1680,1050);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.println("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
        byte[] zipBuffer = ZipUtil.gzipCompress(bytes);
        System.out.println("压缩后的大小:" +zipBuffer.length + "  -->" + (zipBuffer.length / 1024) + "(KB)");
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
