package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_10_多线程下载_断点续传_从保存已下载数据文件继续下载;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午11:48
 * 功能描述: 下载器
 */

public class Downloader {

    DownLoadUI ui;

    Vector<DownLoadThread> downloadThreadVector = new Vector<DownLoadThread>();//一共有多少个下载线程

    public Downloader(DownLoadUI downLoadUI){
        this.ui = downLoadUI;
    }


    /**
     * 下载
     * @param url
     * @param saveFilePath
     * @param threadCount
     */
    public   void download(String url,String saveFilePath,String threadCount){
        ui.updateState("正在准备下载...");


        long timer = System.currentTimeMillis();
        int threadCountInt = Integer.parseInt(threadCount);

        URLConnection conn =  URLUtil.openConnection(url);
        int totalLength = conn.getContentLength();
        if(totalLength == -1 ){
            ui.updateState("下载地址该问不了 -->" +url);
            return;
        }

        ui.updateState("开始下载");
        ui.setProgressBarMaxValue(totalLength);

        System.out.println("文件类型:" + conn.getContentType()+" \t 总文件大小:"+totalLength/1024 +"(KB) --> "+totalLength/1024/1024 +"(MB)" +"\t 文件URL:" +url);
        System.out.println("\n");


        ContinueTransferringBreakpointThread continueTransferringBreakpointThread = new ContinueTransferringBreakpointThread();




            Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,threadCountInt,url,saveFilePath);
            for (DownloadBytesBean d :vector){
                continueTransferringBreakpointThread.getDownloadBytesBeanVector().add(d);

                DownLoadThread downLoadThread = new DownLoadThread(d,ui,continueTransferringBreakpointThread);
                downLoadThread.start();

                downloadThreadVector.add(downLoadThread);

            }
            continueTransferringBreakpointThread.start();




/*        for (DownLoadThread d : downloadThreadVector){
            try {
                d.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/





       // System.out.println("\n");
     //   String exeTime = "\t" + TimerUtil.printWorkerTimeMillis(timer) +"";

       // System.out.println("文件下载完成,保存在:" +saveFilePath );

    }


    public Vector<DownLoadThread> getDownloadThreadVector() {
        return downloadThreadVector;
    }

    public void setDownloadThreadVector(Vector<DownLoadThread> downloadThreadVector) {
        this.downloadThreadVector = downloadThreadVector;
    }
}
