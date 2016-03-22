package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件.n_1_v_4_多线程写入本地文件;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:28
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";


        int totalLength = URLUtil.getContentLength(urlStr);
        System.out.println("总共大小:"+totalLength);
        RandomAccessFile raf = null;
        String saveFilePath = "/opt/temp/apache-tomcat-9.0.0.M4-10.zip";

        try {
             raf = new RandomAccessFile(saveFilePath,"rw");
             Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,10);
             for (DownloadBytesBean d :vector){
                 new DownLoadThread(urlStr,saveFilePath,d).start();
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("文件下载完成,保存在:" +saveFilePath);


    }
}
