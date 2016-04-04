package com.opensourceteams.modules.product.项目.n_03_多线程下载工具.n_02_多线程下载工具_断点续传;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;

import java.io.FileNotFoundException;

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
