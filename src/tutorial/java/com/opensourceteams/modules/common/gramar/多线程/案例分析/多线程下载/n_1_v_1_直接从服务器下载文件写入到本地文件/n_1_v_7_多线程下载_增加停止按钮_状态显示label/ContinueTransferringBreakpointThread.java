package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_7_多线程下载_增加停止按钮_状态显示label;

import java.util.List;

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
                if(list != null){
                    for (DownLoadThread d : list){
                        System.out.println(d);
                    }
                }
                Thread.sleep(1 * 60 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
