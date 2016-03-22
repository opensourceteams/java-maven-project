package com.opensourceteams.modules.common.gramar.多线程.案例分析.n_10_多线程下载.n_03_URL基本操作_设置分配每个线程的数据范围;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import com.opensourceteams.modules.common.java.lang.ByteArrayUtil;
import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  下午5:58
 * 功能描述:
 */

public class Run {


    public static void main(String[] args) throws Exception{

        String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";

        URLConnection conn = URLUtil.openConnection(urlStr);
        int length = URLUtil.getContentLength(conn);
        Vector<DownloadBytesBean> vector =  SplitArrayUtil.splitBytesToVector(length,100,1024 * 1024 *2 );


        for (int i = 0 ;i < vector.size();i ++){
            DownloadBytesBean d = vector.get(i);
            System.out.println(i + " "+d.getBeginIndex()+":" + d.getEndIndex()+":"  + d.getLength());
        }



    }
}
