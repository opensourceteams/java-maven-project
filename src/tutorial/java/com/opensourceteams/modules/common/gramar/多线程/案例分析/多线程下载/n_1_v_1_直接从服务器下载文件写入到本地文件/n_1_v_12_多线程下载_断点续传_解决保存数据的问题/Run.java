package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_12_多线程下载_断点续传_解决保存数据的问题;


/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午11:28
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        DownLoadUI downLoadUI = new DownLoadUI("文氏下载器");
        Downloader downloader = new Downloader(downLoadUI);

        downloader.breakpointPrepare();




    }
}
