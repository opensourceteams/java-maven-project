package com.opensourceteams.modules.product.项目.n_03_多线程下载工具.n_01_多线程下载工具;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:17
 * 功能描述:
 */

public class DownLoadThread extends Thread{

    DownloadBytesBean downloadBytesBean;
    RandomAccessFile raf;
    DownLoadUI ui;
    ContinueTransferringBreakpointThread continueTransferringBreakpointThread;




    public DownLoadThread(DownloadBytesBean downloadBytesBean, DownLoadUI ui, ContinueTransferringBreakpointThread continueTransferringBreakpointThread){
        this.downloadBytesBean = downloadBytesBean;
        this.ui = ui;
        this.continueTransferringBreakpointThread = continueTransferringBreakpointThread;

    }
    @Override
    public void run() {
        continueTransferringBreakpointThread.getDownloadBytesBeanVector().add(downloadBytesBean);
        long time = System.currentTimeMillis();
        System.out.println("本次开始下载    -->    " +downloadBytesBean);

        try {
            raf = new RandomAccessFile(downloadBytesBean.getSaveFilePath(),"rw");
            boolean result = Download_URLUtil.download(downloadBytesBean);
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
