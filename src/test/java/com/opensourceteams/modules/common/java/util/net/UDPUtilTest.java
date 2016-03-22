package com.opensourceteams.modules.common.java.util.net;

import com.opensourceteams.modules.common.java.algorithm.NextValueUtil;
import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.util.awt.ScreenCaptureUtil;
import com.opensourceteams.modules.common.java.util.zip.ZipUtil;
import org.junit.Test;

import java.awt.*;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  上午6:56
 * 功能描述:
 */

public class UDPUtilTest {

    boolean debug = false;
    
    String receiveIp = "192.168.12.1";


    /**
     * 接收bytes
     */
    @Test
    public void testReveiveBytes(){

        byte[] bytes = UDPUtil.reveiveOnce(8889);
        for (byte v : bytes){
            System.out.println(v);
        }


    }


    /**
     * 发送bytes
     */
    @Test
    public void testSenderBytes(){


        byte[] bytes = new byte[5];
        for (int i =0 ;i< bytes.length;i++){
            bytes[i] = (byte) i;
        }

        UDPUtil.senderOnce(8889,receiveIp,8888,bytes);
    }

    /**
     * 接收bytes,的一张图片
     */
    @Test
    public void testReveiveBytesImage(){

        byte[] bytes = UDPUtil.reveiveOnce(8889);
        System.out.printf("收到的长度:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
        ScreenCaptureUtil.bytesToImageFile(bytes,"jpg","temp/screen_convert_output.jpg");

    }


    /**
     * 发送bytes,一张图片
     */
    @Test
    public void testSenderBytesImage(){


        Rectangle rect = new Rectangle(1200,0,400,300);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");

        UDPUtil.senderOnce(8889,receiveIp,8888,bytes);
    }

    /**
     * 发送bytes,一张图片,压缩,分包
     */
    @Test
    public void testSenderBytesImageGZipCompress(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();
        System.out.println("客户端:width:" + width + " height:" + height);


        Rectangle rect = new Rectangle(0,0,width,height);
        byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
        System.out.println("抓到屏幕的大小:" +bytes.length + "  --> " + (bytes.length / 1024) + "(KB)");

        //压缩
        byte[] zipBuffer = ZipUtil.gzipCompress(bytes);
        System.out.println("压缩后的数据大小:" + zipBuffer.length + "  --> "  + zipBuffer.length /1024 + "(KB)") ;

        //分包
        java.util.List<byte[]> list  = SplitArrayUtil.splitArray(zipBuffer,1024 * 50, (byte) 1);

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        for (byte[] sub : list){

            byte type = SplitArrayUtil.getSplitValue(sub[0])[0];
            byte currentCount = SplitArrayUtil.getSplitValue(sub[0])[1];
            byte totalCount = sub[1];
            System.out.println("包类型" +type +" 当前包数:" + currentCount +" 总包数:" + totalCount +" 每个包的长度:" +sub.length + "  -->" + (sub.length / 1024) + "(KB)");

            //发送
            //UDPUtil.senderOnce(8889,receiveIp,8888,sub);
            UDPUtil.sender( socket,8889,receiveIp, sub);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //UDPUtil.senderOnce(8889,receiveIp,8888,bytes);
    }


    /**
     * 循环发送bytes,一张图片,压缩,分包
     */
    @Test
    public void testSenderBytesImageGZipCompressN(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screensize.getWidth();
        int height = (int)screensize.getHeight();
        System.out.println("客户端:width:" + width + " height:" + height);


        Rectangle rect = new Rectangle(0,0,width,height);
        int currentValue = 0 ;

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true){
            //抓到的屏幕
            byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");

            //压缩
            byte[] zipBuffer = ZipUtil.gzipCompress(bytes);




            //当前数据包编号
            currentValue = NextValueUtil.getNextValue(currentValue,1);
            //分包
            java.util.List<byte[]> list  = SplitArrayUtil.splitArray(zipBuffer,1024 * 50, (byte) currentValue);
            for (byte[] sub : list){

                byte type = SplitArrayUtil.getSplitValue(sub[0])[0];
                byte currentCount = SplitArrayUtil.getSplitValue(sub[0])[1];
                byte totalCount = sub[1];

                if(debug){
                    System.out.println("抓到屏幕的大小:" +bytes.length + "  --> " + (bytes.length / 1024) + "(KB)");
                    System.out.println("压缩后的数据大小:" + zipBuffer.length + "  --> "  + zipBuffer.length /1024 + "(KB)") ;
                    System.out.println("包类型" +type +" 当前包数:" + currentCount +" 总包数:" + totalCount +" 每个包的长度:" +sub.length + "  -->" + (sub.length / 1024) + "(KB)");

                }
                //发送
                //UDPUtil.senderOnce(8889,receiveIp,8888,sub);
                UDPUtil.sender( socket,8889,receiveIp, sub);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 循环发送bytes,一张图片
     */
    @Test
    public void testSenderBytesImageN(){




        Rectangle rect = new Rectangle(800,0,800,400);
        while (true){
            byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
            System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");

            UDPUtil.senderOnce(8889,receiveIp,8888,bytes);

        }

    }


    /**
     * 循环接收bytes,的一张图片
     */
    @Test
    public void testReveiveBytesImages(){



        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8889);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        int i = 0;
        String filePath = "";
        while (true){
            byte[] bytes = UDPUtil.reveive(socket);
            System.out.print("收到的长度:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");
            filePath = "temp/images/screen_convert_output_"+(i++)+".jpg";
            ScreenCaptureUtil.bytesToImageFile(bytes,"jpg",filePath);
            System.out.println("   收到的图片:" +filePath);
        }




    }


    /**
     * 循环发送bytes,一张图片
     */
    @Test
    public void testSenderBytesImages(){




        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        Rectangle rect = new Rectangle(1200,0,400,300);
        boolean isloop = true;
        while (isloop){
            //isloop = false;
            byte[] bytes = ScreenCaptureUtil.screenCaptureToBytes(rect,"jpg");
            System.out.printf("抓到屏幕的大小:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");


            UDPUtil.sender(socket,8889,receiveIp,bytes);

            if(isloop){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }






}
