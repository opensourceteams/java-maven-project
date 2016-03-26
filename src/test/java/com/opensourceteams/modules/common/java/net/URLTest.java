package com.opensourceteams.modules.common.java.net;

import com.opensourceteams.modules.common.java.util.zip.ZipUtil;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  下午4:39
 * 功能描述:
 */

public class URLTest {
    String urlString = "http://www.baidu.com/index.htm";
    @Test
    public void testURL() throws Exception {
        URL url = new URL(urlString);

        URLConnection conn =  url.openConnection();
        System.out.println(url.getContent());
        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getPort());

        System.out.println(conn.getContentEncoding());
        System.out.println(conn.getContentLength());
        InputStream is = conn.getInputStream();
        int len = 0 ;

       // connection.setRequestProperty();
        byte[] buffer = new byte[1024];
        GZIPInputStream zip = new GZIPInputStream(is );
        FileOutputStream fos = new FileOutputStream("/opt/temp/baidu.txt");

        while ((len =zip.read(buffer) ) !=-1){
            fos.write(buffer,0,len);
        }


        fos.close();
        is.close();
        System.out.println("over");
    }
}
