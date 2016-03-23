package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_5_多线程写入本地文件_增加UI;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.timer.TimerUtil;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:17
 * 功能描述:
 */

public class DownLoadThread extends Thread{

    String urlStr;
    String saveFilePath;
    DownloadBytesBean downloadBytesBean;
    RandomAccessFile raf;


    public DownLoadThread(String urlStr, String saveFilePath, DownloadBytesBean downloadBytesBean){
        this.urlStr = urlStr;
        this.saveFilePath = saveFilePath;
        this.downloadBytesBean = downloadBytesBean;

    }
    @Override
    public void run() {
        long time = System.currentTimeMillis();
        System.out.println("本次开始下载    -->    " +downloadBytesBean);
        try {
            raf = new RandomAccessFile(saveFilePath,"rw");
            byte[] bytes = URLUtil.getBytes(urlStr,downloadBytesBean.getBeginIndex(),downloadBytesBean.getEndIndex());
            raf.seek(downloadBytesBean.getBeginIndex());
            raf.write(bytes);
            String exeTime = TimerUtil.printWorkerTimeMillis(time) +"";
            System.out.println(downloadBytesBean );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
