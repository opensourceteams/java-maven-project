package com.opensourceteams.modules.common.java.util.net;

import com.opensourceteams.modules.common.java.algorithm.SplitArrayUtil;
import com.opensourceteams.modules.common.java.algorithm.bean.DownloadBytesBean;
import org.junit.Test;

import java.io.*;
import java.net.URLConnection;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午5:43
 * 功能描述:
 */

public class URLUtilTest {


    /**
     * 直接把远程文件写到本地
     * @throws Exception
     */
    @Test
    public void testReadRemoteFile() throws Exception {
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

    /**
     * 从服务器下载分隔好的文件,一次写入本地,示加多线程,本地是循环写入
     * @throws FileNotFoundException
     */
    @Test
    public void testDownloadFileSplit() throws Exception {
        String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";


        int totalLength = URLUtil.getContentLength(urlStr);

        URLConnection conn = URLUtil.openConnection(urlStr);

        FileOutputStream fos = new FileOutputStream("/opt/temp/apache-tomcat-9.0.0.M4-6.zip");

        System.out.println(totalLength);
        Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,10);
        int cal =0 ;
        for (int i = 0 ;i < vector.size();i++){

            DownloadBytesBean d = vector.get(i);
            byte[] bytes = URLUtil.getBytes(urlStr,d.getBeginIndex(),d.getEndIndex());
            try {
                fos.write(bytes);
                System.out.println(i + " 已写入:" + bytes.length);
                cal=cal +bytes.length;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cal);
       // System.out.println(conn.getContentLength());


    }

    /**
     * ).从服务器下载分隔好的文件
     * ).示加多线程,
     * ).本地是循环写入
     * ).本地文件每次写入会定位
     * @throws FileNotFoundException
     */
    @Test
    public void testDownloadSplitFileLocalFixedPosition() throws Exception {
        String urlStr = "http://100.68.68.101/apache.mirrors.lucidnetworks.net/tomcat/tomcat-9/v9.0.0.M4/bin/apache-tomcat-9.0.0.M4.zip";


        int totalLength = URLUtil.getContentLength(urlStr);
        System.out.println("总共有多大:"+totalLength);


        //FileOutputStream fos = new FileOutputStream("/opt/temp/apache-tomcat-9.0.0.M4-6.zip");
        RandomAccessFile raf = new RandomAccessFile("/opt/temp/apache-tomcat-9.0.0.M4-8.zip","rw");




        Vector<DownloadBytesBean> vector = SplitArrayUtil.splitBytesToVector(totalLength,10);
        int cal =0 ;
        for (int i = 0 ;i < vector.size();i++){

            DownloadBytesBean d = vector.get(i);
            byte[] bytes = URLUtil.getBytes(urlStr,d.getBeginIndex(),d.getEndIndex());
            try {
                raf.seek(d.getBeginIndex());
                raf.write(bytes);
                System.out.println(i + " 已写入:" + bytes.length);
                cal=cal +bytes.length;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(raf != null){
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cal);
        // System.out.println(conn.getContentLength());


    }
}
