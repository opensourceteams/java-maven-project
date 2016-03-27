package com.opensourceteams.modules.product.项目.n_01_屏广软件.n_01_v_01_屏广软件;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.util.net.UDPUtil;
import com.opensourceteams.modules.common.java.util.zip.ZipUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午2:12
 * 功能描述:
 */

public class TaskThread extends Thread {


    boolean debug = true;
    long timeInterval = 1000;
    JButton btnShowImg ;
    DatagramSocket socket ;
    static Map<Byte, byte[]> map = new HashMap<Byte, byte[]>();
    static byte lastType = 0 ;


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
                /**
                 * 解析包
                 */


                byte type = SplitArrayUtil.getSplitValue(bytes[0])[0];
                byte currentCount = SplitArrayUtil.getSplitValue(bytes[0])[1];
                byte totalCount = bytes[1];
                if(debug){
                    System.out.println("开始解析包");
                    System.out.println("包类型" +type +" 当前包数:" + currentCount +" 总包数:" + totalCount +" 每个包的长度:" +bytes.length + "  -->" + (bytes.length / 1024) + "(KB)");

                }

                byte[] dataBytes = new byte[bytes.length - 2];
                System.arraycopy(bytes,2,dataBytes,0,dataBytes.length );

                //有新的数据包发过来了
                if(type != lastType){
                    refreshData();
                    lastType =  type;

                }

                map.put(currentCount,dataBytes);

                if(map.size() == totalCount){
                   //说明当前包已经装满了
                    if (debug){
                        System.out.println("满了");
                    }



                    //得到总byte数组数据
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    for (Map.Entry<Byte, byte[]> entry : map.entrySet()){

                        bytes = entry.getValue();
                        baos.write(bytes);
                    }

                    //解压数据
                    byte[] zipBytes = ZipUtil.gZipExtract(baos.toByteArray());

                    /**
                     * 转换数据
                     */
                    ByteArrayInputStream bais = new ByteArrayInputStream(zipBytes);
                    bufferedImage = ImageIO.read(bais);
                    btnShowImg.setIcon(null);
                    btnShowImg.setIcon(new ImageIcon(bufferedImage,""));

                    //有新的数据包发过来了
                    if(type != lastType){
                        refreshData();

                    }



                }





            } catch (Exception e) {
                e.printStackTrace();
                refreshData();
            }




        }
    }

    public  void refreshData(){
        map = new HashMap<Byte, byte[]>();
        lastType = -1;
    }
}
