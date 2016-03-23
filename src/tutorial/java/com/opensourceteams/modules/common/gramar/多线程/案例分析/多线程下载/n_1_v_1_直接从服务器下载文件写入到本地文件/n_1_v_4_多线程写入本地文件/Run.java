package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_4_多线程写入本地文件;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.timer.TimerUtil;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:28
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) throws Exception {
        long timer = System.currentTimeMillis();

        String urlStr = "http://110.96.193.5:81/1Q2W3E4R5T6Y7U8I9O0P1Z2X3C4V5B/apache.fayea.com/hadoop/common/hadoop-2.6.4/hadoop-2.6.4.tar.gz";


        URLConnection conn =  URLUtil.openConnection(urlStr);
        int totalLength = conn.getContentLength();
        if(totalLength == -1 ){
            throw new Exception("该问不了 -->" +urlStr);
        }
        System.out.println("文件类型:" + conn.getContentType()+" \t 总文件大小:"+totalLength/1024 +"(KB) --> "+totalLength/1024/1024 +"(MB)" +"\t 文件URL:" +urlStr);
        System.out.println("\n");
        RandomAccessFile raf = null;
        String saveFilePath = "/opt/temp/hadoop-2.6.4.tar.gz";


        List<DownLoadThread> list = new ArrayList<DownLoadThread>();
        try {
             raf = new RandomAccessFile(saveFilePath,"rw");
             Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,200);
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





        System.out.println("\n");
        String exeTime = "\t" +TimerUtil.printWorkerTimeMillis(timer) +"";

        System.out.println("文件下载完成,保存在:" +saveFilePath );


    }
}
