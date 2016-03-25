package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_10_多线程下载_断点续传_从保存已下载数据文件继续下载_2;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.util.net.URLUtil;
import com.opensourceteams.modules.common.java.util.properties.PropertiesUtil;

import java.io.File;
import java.net.URLConnection;
import java.util.*;

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


    public void breakpoint(String url,String saveFilePath,String threadCount){
        File file = new File(saveFilePath);

        File fileDownload = new File(saveFilePath+".download");
        if(file != null && fileDownload != null && file.exists() && fileDownload.exists()){

            Properties p = PropertiesUtil.getProperties(saveFilePath+".download");
            int threadCountContinue = 0 ;
            threadCountContinue = p.getProperty("thread.count") == null ? 0 : Integer.parseInt(p.getProperty("thread.count"));
            if (threadCountContinue > 0){
                //进行继传
                Map<String,String> map = PropertiesUtil.getPropertiesPrefix(p,"thread.index");
                List<DownloadBytesBean> downloadBytesBeanList = new ArrayList<DownloadBytesBean>();
                DownloadBytesBean downloadBytesBean = new DownloadBytesBean();
                for (Map.Entry<String,String> entry : map.entrySet()){
                    System.out.println(entry.getKey() +":" +entry.getValue());
                    downloadBytesBean.setBeginIndex(Integer.parseInt(entry.getValue().split(",")[0]));
                    downloadBytesBean.setAmount(Integer.parseInt(entry.getValue().split(",")[1]));
                    downloadBytesBean.setEndIndex(downloadBytesBean.getIndex() + downloadBytesBean.getAmount());
                    downloadBytesBeanList.add(downloadBytesBean);
                    continueDownload(downloadBytesBeanList,threadCount);

                }

            }else{
                download(url, saveFilePath, threadCount);
            }

        }else {
            download(url, saveFilePath, threadCount);
        }

    }

    private void continueDownload(List<DownloadBytesBean> downloadBytesBeanList,String threadCount) {

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


            }
            continueTransferringBreakpointThread.start();


    }



}
