package com.opensourceteams.modules.product.项目.n_01_屏广软件.n_01_v_01_屏广软件;

import com.opensourceteams.modules.common.java.algorithm.NextValueUtil;
import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.util.awt.ScreenCaptureUtil;
import com.opensourceteams.modules.common.java.util.net.UDPUtil;
import com.opensourceteams.modules.common.java.util.zip.ZipUtil;
import org.junit.Test;

import java.awt.*;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 日期: 2016-03-25  19:40
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class SenderRun {

    boolean debug = true;

    String receiveIp = "192.168.12.17";
    int receiverPort = Constanct.getReceiverPort();
    int senderPort = Constanct.getSenderPort() ;

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
            socket = new DatagramSocket(senderPort);
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
            UDPUtil.sender( socket,receiverPort,receiveIp, sub);
            try {
                Thread.sleep(1);
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
            socket = new DatagramSocket(senderPort);
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
                UDPUtil.sender( socket,receiverPort,receiveIp, sub);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
