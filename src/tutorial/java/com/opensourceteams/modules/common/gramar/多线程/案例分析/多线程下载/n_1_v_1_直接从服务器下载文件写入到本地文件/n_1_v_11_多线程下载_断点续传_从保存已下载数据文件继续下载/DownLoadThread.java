package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_11_多线程下载_断点续传_从保存已下载数据文件继续下载;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:17
 * 功能描述:
 */

public class  DownLoadThread extends Thread{

    DownloadBytesBean downloadBytesBean;
    //RandomAccessFile raf;
    DownLoadUI ui;
    boolean isBreakpoint = false;
    String url;
    String saveFilePath;




    public DownLoadThread(String url,String saveFilePath,boolean isBreakpoint,DownloadBytesBean downloadBytesBean, DownLoadUI ui){
        this.url = url;
        this.saveFilePath = saveFilePath;
        this.isBreakpoint = isBreakpoint;
        this.downloadBytesBean = downloadBytesBean;
        this.ui = ui;

    }
    @Override
    public void run() {

        long time = System.currentTimeMillis();
        System.out.println("本次开始下载    -->    " + downloadBytesBean);

        try {
           // raf = new RandomAccessFile(downloadBytesBean.getSaveFilePath(),"rw");
            boolean result = false;
            if(isBreakpoint){
                result = Download_URLUtil.downloadBreakpoint(url,saveFilePath,downloadBytesBean,ui);
            }else {
                 result = Download_URLUtil.download(downloadBytesBean,ui);
            }

            if (!result){
                return;
            }

            System.out.println(downloadBytesBean );
            downloadBytesBean.setOver(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public DownloadBytesBean getDownloadBytesBean() {
        return downloadBytesBean;
    }

    public void setDownloadBytesBean(DownloadBytesBean downloadBytesBean) {
        this.downloadBytesBean = downloadBytesBean;
    }



    @Override
    public String toString() {
        return "downloadBytesBean:" +downloadBytesBean;
    }



}
