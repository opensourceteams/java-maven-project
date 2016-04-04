package com.opensourceteams.modules.product.项目.n_03_多线程下载工具.n_02_多线程下载工具_断点续传;


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
