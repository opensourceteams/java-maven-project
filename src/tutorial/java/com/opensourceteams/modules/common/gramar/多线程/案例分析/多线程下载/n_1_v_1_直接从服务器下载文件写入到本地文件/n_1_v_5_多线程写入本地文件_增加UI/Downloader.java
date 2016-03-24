package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_5_多线程写入本地文件_增加UI;

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
 * 16/3/23  上午11:48
 * 功能描述: 下载器
 */

public class Downloader {

    DownLoadUI ui;

    public Downloader(DownLoadUI downLoadUI){
        this.ui = downLoadUI;
    }




    public   void download(String url,String saveFilePath,String threadCount){


        long timer = System.currentTimeMillis();
        int threadCountInt = Integer.parseInt(threadCount);

        URLConnection conn =  URLUtil.openConnection(url);
        int totalLength = conn.getContentLength();
        if(totalLength == -1 ){
            System.out.println("该问不了 -->" +url);
            return;
        }

        ui.setProgressBarMaxValue(totalLength);

        System.out.println("文件类型:" + conn.getContentType()+" \t 总文件大小:"+totalLength/1024 +"(KB) --> "+totalLength/1024/1024 +"(MB)" +"\t 文件URL:" +url);
        System.out.println("\n");
        RandomAccessFile raf = null;


        List<DownLoadThread> list = new ArrayList<DownLoadThread>();
        try {
            raf = new RandomAccessFile(saveFilePath,"rw");
            Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,threadCountInt,"","");
            for (DownloadBytesBean d :vector){
                DownLoadThread downLoadThread = new DownLoadThread(url,saveFilePath,d,ui);
                downLoadThread.start();

                list.add(downLoadThread);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

/*        for (DownLoadThread d : list){
            try {
                d.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/





        System.out.println("\n");
        String exeTime = "\t" + TimerUtil.printWorkerTimeMillis(timer) +"";

        System.out.println("文件下载完成,保存在:" +saveFilePath );

    }
}
