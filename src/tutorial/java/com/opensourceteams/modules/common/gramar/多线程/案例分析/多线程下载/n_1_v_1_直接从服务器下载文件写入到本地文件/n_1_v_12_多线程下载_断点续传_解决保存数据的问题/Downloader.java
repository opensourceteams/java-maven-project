package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_12_多线程下载_断点续传_解决保存数据的问题;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.util.net.URLUtil;
import com.opensourceteams.modules.common.java.util.properties.PropertiesUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URLConnection;
import java.util.*;


/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午11:48
 * 功能描述: 下载器
 */

public class Downloader {

    DownLoadUI ui; //

    ContinueTransferringBreakpointThread continueTransferringBreakpointThread = new ContinueTransferringBreakpointThread();


    public Downloader(DownLoadUI downLoadUI){
        this.ui = downLoadUI;
        continueTransferringBreakpointThread.start();

    }



    /**
     * 准备断点继续下载
     */
    public void breakpointPrepare() {
        File file = new File(Constant.downloadPathRoot);

        if (file != null && file.isDirectory()) {
            String[] files = file.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    if (name != null && name.toLowerCase().endsWith(".download")) {
                        return true;
                    }
                    return false;
                }
            });
            if(files == null || files.length <=0){
                return;
            }
            String metadataPath = Constant.downloadPathRoot + "/" + files[0];
            String downloadPath = metadataPath.substring(0, metadataPath.lastIndexOf(".download"));
            System.out.println(metadataPath);

            File downFile = new File(downloadPath);

            File fileDownloadMetadata = new File(metadataPath);
            if (file != null && fileDownloadMetadata != null && file.exists() && fileDownloadMetadata.exists()) {
                //说明,上次有文件没下载完成

                Properties p = PropertiesUtil.getProperties(metadataPath);
                int threadCountContinue = 0;
                int totalLength = 0 ;
                threadCountContinue = p.getProperty("thread.count") == null ? 0 : Integer.parseInt(p.getProperty("thread.count"));
                totalLength = p.getProperty("thread.totalLength") == null ? 0 : Integer.parseInt(p.getProperty("thread.totalLength"));
                ui.setProgressBarMaxValue(totalLength);
                if (threadCountContinue > 0) {
                    //进行继传
                    Map<String, String> map = PropertiesUtil.getPropertiesPrefix(p, "thread.index");
                    List<DownloadBytesBean> downloadBytesBeanList = new ArrayList<DownloadBytesBean>();
                    int totalAmount = 0 ;
                    DownloadBytesBean downloadBytesBean = new DownloadBytesBean();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        totalAmount = totalAmount + Integer.parseInt(entry.getValue().split(",")[1]);
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                        downloadBytesBean.setBeginIndex(Integer.parseInt(entry.getValue().split(",")[0]));
                        downloadBytesBean.setAmount(Integer.parseInt(entry.getValue().split(",")[1]));
                        downloadBytesBean.setEndIndex(Integer.parseInt(entry.getValue().split(",")[2]));
                        downloadBytesBeanList.add(downloadBytesBean);
                        //continueDownload(downloadBytesBeanList, threadCount);

                    }
                    ui.setProgressBarCurrentValue(totalAmount);

                }
            }


        }
    }


    /**
     * 继续下载
     * @param maxThread
     */
    public void continueDownload(String maxThread) {
        File file = new File(Constant.downloadPathRoot);

        if (file != null && file.isDirectory()) {
            String[] files = file.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    if (name != null && name.toLowerCase().endsWith(".download")) {
                        return true;
                    }
                    return false;
                }
            });
            if(files == null || files.length <=0){
                return;
            }
            String metadataPath = Constant.downloadPathRoot + "/" + files[0];
            String downloadPath = metadataPath.substring(0, metadataPath.lastIndexOf(".download"));
            System.out.println(metadataPath);
            String url = "";

            File downFile = new File(downloadPath);

            File fileDownloadMetadata = new File(metadataPath);
            if (file != null && fileDownloadMetadata != null && file.exists() && fileDownloadMetadata.exists()) {
                //说明,上次有文件没下载完成

                Properties p = PropertiesUtil.getProperties(metadataPath);
                int threadCountContinue = 0;
                int totalLength = 0 ;
                String saveFilePath = "";
                threadCountContinue = p.getProperty("thread.count") == null ? 0 : Integer.parseInt(p.getProperty("thread.count"));
                totalLength = p.getProperty("thread.totalLength") == null ? 0 : Integer.parseInt(p.getProperty("thread.totalLength"));
                url = p.getProperty("url") ;
                saveFilePath = p.getProperty("saveFilePath") ;
                ui.setProgressBarMaxValue(totalLength);
                if (threadCountContinue > 0) {
                    //进行继传
                    Map<String, String> map = PropertiesUtil.getPropertiesPrefix(p, "thread.index");
                    Vector<DownloadBytesBean> downloadBytesBeanVector = new Vector<DownloadBytesBean>();
                    int totalAmount = 0 ;
                    DownloadBytesBean downloadBytesBean = null;
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        downloadBytesBean = new DownloadBytesBean();

                        totalAmount = totalAmount + Integer.parseInt(entry.getValue().split(",")[1]);
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                        downloadBytesBean.setBeginIndex(Integer.parseInt(entry.getValue().split(",")[0]));
                        downloadBytesBean.setAmount(Integer.parseInt(entry.getValue().split(",")[1]));
                        downloadBytesBean.setEndIndex(Integer.parseInt(entry.getValue().split(",")[2]));
                        //downloadBytesBean.setSaveFilePath(saveFilePath);
                        downloadBytesBeanVector.add(downloadBytesBean);

                        //continueDownload(downloadBytesBeanList, threadCount);

                    }
                    ui.setProgressBarCurrentValue(totalAmount);


                    //Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVectorBreakpoint(totalLength,Integer.parseInt(maxThread),downloadBytesBeanList,totalAmount);
                    //System.out.println(vector);
                    downloadBreakpoint(url,saveFilePath,maxThread,downloadBytesBeanVector);


                }
            }


        }
    }

    public void downloadBreakpoint(String url,String saveFilePath,String threadCount, Vector<DownloadBytesBean> downloadBytesBeanVector ){

        URLConnection conn =  URLUtil.openConnection(url);
        int totalLength = conn.getContentLength();
        if(totalLength == -1 ){
            ui.updateState("下载地址该问不了 -->" +url);
            return;
        }

        Vector<DownloadBytesBean> vector = AlgorithmDownUtil.breakpoint(url,saveFilePath,Integer.parseInt(threadCount),totalLength,downloadBytesBeanVector);

         continueTransferringBreakpointThread.removeAllDownloadBytesBeanVector();
        if(vector != null && vector.size()>0){
            for (DownloadBytesBean d : vector){

                continueTransferringBreakpointThread.addDownloadBytesBeanVector(d);
                DownLoadThread downLoadThread = new DownLoadThread(url,saveFilePath,true,d,ui,continueTransferringBreakpointThread);
                downLoadThread.start();
            }


        }
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



            Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,threadCountInt,url,saveFilePath);
            for (DownloadBytesBean d :vector){
                continueTransferringBreakpointThread.addDownloadBytesBeanVector(d);

                DownLoadThread downLoadThread = new DownLoadThread(url,saveFilePath,false,d,ui,continueTransferringBreakpointThread);
                downLoadThread.start();



            }


    }



}
