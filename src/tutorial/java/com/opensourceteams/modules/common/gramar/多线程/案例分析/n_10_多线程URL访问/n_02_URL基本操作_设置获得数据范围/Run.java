package com.opensourceteams.modules.common.gramar.多线程.案例分析.n_10_多线程URL访问.n_02_URL基本操作_设置获得数据范围;

import java.net.URL;
import java.net.URLConnection;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  下午5:58
 * 功能描述:
 */

public class Run {

    static String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";

    public static void main(String[] args) throws Exception{


        URL url = new URL(urlStr);

        URLConnection urlConnection = url.openConnection();

        urlConnection.setRequestProperty("Range","bytes=9877700-9877800");
        System.out.println("内容对象:"+urlConnection.getContent());
        System.out.println("内容类型:" +urlConnection.getContentType());
        System.out.println("内容长度:" + urlConnection.getContentLength());
        System.out.println("内容长度Long:" + urlConnection.getContentLengthLong());
        System.out.println("内容编码:" +urlConnection.getContentEncoding());

    }
}
