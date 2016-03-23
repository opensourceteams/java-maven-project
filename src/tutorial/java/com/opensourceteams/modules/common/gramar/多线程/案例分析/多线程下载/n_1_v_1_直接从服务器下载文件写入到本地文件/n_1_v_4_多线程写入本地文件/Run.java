package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_4_多线程写入本地文件;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.timer.TimerUtil;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:28
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        long timer = System.currentTimeMillis();

        String urlStr = "http://110.96.192.8:81/1Q2W3E4R5T6Y7U8I9O0P1Z2X3C4V5B/apache.opencas.org/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";


        int totalLength = URLUtil.getContentLength(urlStr);
        System.out.println("总文件大小:"+totalLength/1024 +"(KB)" +"\t 文件URL:" +urlStr);
        System.out.println("\n");
        RandomAccessFile raf = null;
        String saveFilePath = "/opt/temp/apache-tomcat-9.0.0.M4-10.zip";


        List<DownLoadThread> list = new ArrayList<DownLoadThread>();
        try {
             raf = new RandomAccessFile(saveFilePath,"rw");
             Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,1000);
             for (DownloadBytesBean d :vector){
                 DownLoadThread downLoadThread = new DownLoadThread(urlStr,saveFilePath,d);
                 downLoadThread.start();

                 list.add(downLoadThread);

             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (DownLoadThread d : list){
            try {
                d.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        String exeTime = TimerUtil.printWorkerTimeMillis(timer) +"";

        System.out.println("\n");

        System.out.println("文件下载完成,保存在:" +saveFilePath  +exeTime);


    }
}
