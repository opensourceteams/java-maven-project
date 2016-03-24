package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_8_多线程下载_断点续传;

import com.opensourceteams.modules.common.java.io.file.FilePathUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * 日期: 2016-03-24  07:13
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:断点续传线程类
 * ).每隔一段时间,将当前已下载量保存到文件中
 */
public class ContinueTransferringBreakpointThread extends Thread{

    List<DownLoadThread> list;


    public ContinueTransferringBreakpointThread(List<DownLoadThread> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            try {
                Properties p = new Properties();
                String filePath = "a.tmp";
                FilePathUtil.createNewFile(filePath);
                p.load(new FileInputStream(filePath));
                char split = ',';
                if(list != null){
                    StringBuffer sb = null;
                    for (DownLoadThread d : list){
                        System.out.println("断点续传保存的东西:" +d);
                        d.getDownloadBytesBean().getBeginIndex() ;
                        d.getDownloadBytesBean().getAmount();
                        d.getDownloadBytesBean().getIndex();

                        sb = new StringBuffer();
                        sb.append(d.getDownloadBytesBean().getBeginIndex());
                        sb.append(split);
                        sb.append(d.getDownloadBytesBean().getAmount());


                        p.setProperty("thread." + d.getDownloadBytesBean().getIndex(),sb.toString());

                    }
                }
                Thread.sleep(5 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
