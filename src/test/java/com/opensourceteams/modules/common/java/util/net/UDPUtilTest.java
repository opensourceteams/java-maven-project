package com.opensourceteams.modules.common.java.util.net;

import com.opensourceteams.modules.common.java.util.awt.ScreenCaptureUtil;
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

        UDPUtil.senderOnce(8889,"192.168.12.1",8888,bytes);
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

        UDPUtil.senderOnce(8889,"192.168.12.1",8888,bytes);
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

            UDPUtil.senderOnce(8889,"192.168.12.1",8888,bytes);

   /*         try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
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


            UDPUtil.sender(socket,8889,"192.168.12.1",bytes);

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
