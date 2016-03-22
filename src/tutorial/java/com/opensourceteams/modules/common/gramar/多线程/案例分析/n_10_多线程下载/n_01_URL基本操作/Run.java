package com.opensourceteams.modules.common.gramar.多线程.案例分析.n_10_多线程下载.n_01_URL基本操作;

import java.net.URL;
import java.net.URLConnection;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  下午5:58
 * 功能描述:
 */

public class Run {

    static String urlStr = "http://110.96.192.8:81/1Q2W3E4R5T6Y7U8I9O0P1Z2X3C4V5B/apache.stu.edu.tw/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";

    public static void main(String[] args) throws Exception{


        URL url = new URL(urlStr);

        URLConnection urlConnection = url.openConnection();

        System.out.println("内容对象:"+urlConnection.getContent());
        System.out.println("内容类型:" +urlConnection.getContentType());
        System.out.println("内容长度:" + urlConnection.getContentLength());
        System.out.println("内容编码:" +urlConnection.getContentEncoding());

    }
}
