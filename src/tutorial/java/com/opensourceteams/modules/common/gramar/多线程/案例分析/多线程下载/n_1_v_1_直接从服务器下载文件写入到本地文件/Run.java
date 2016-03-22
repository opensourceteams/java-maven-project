package com.opensourceteams.modules.common.gramar.多线程.案例分析.多线程下载.n_1_v_1_直接从服务器下载文件写入到本地文件;

import com.opensourceteams.modules.common.java.util.net.URLUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午7:15
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) throws Exception {
        String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";

        URLConnection conn = URLUtil.openConnection(urlStr);
        System.out.println(conn.getContentLength());
        System.out.println(conn.getContentType());

        FileOutputStream fos = new FileOutputStream("/opt/temp/apache-tomcat-9.0.0.M4.zip");
        InputStream is = conn.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0 ;
        while ( (len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
    }
}
