package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_7_多线程下载_增加停止按钮_状态显示label;

import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.timer.TimerUtil;

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
    DownLoadUI ui;




    public DownLoadThread(String urlStr, String saveFilePath, DownloadBytesBean downloadBytesBean, DownLoadUI ui){
        this.urlStr = urlStr;
        this.saveFilePath = saveFilePath;
        this.downloadBytesBean = downloadBytesBean;
        this.ui = ui;

    }
    @Override
    public void run() {
        long time = System.currentTimeMillis();
        System.out.println("本次开始下载    -->    " +downloadBytesBean);
        try {
            raf = new RandomAccessFile(saveFilePath,"rw");
            byte[] bytes = Download_URLUtil.getBytesIsSuspend(urlStr,downloadBytesBean);
            if (bytes == null){
                return;
            }
            raf.seek(downloadBytesBean.getBeginIndex());
            raf.write(bytes);
            String exeTime = TimerUtil.printWorkerTimeMillis(time) +"";
            System.out.println(downloadBytesBean );
            ui.setProgressBarCurrentValue(bytes.length);

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
