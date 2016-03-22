package com.opensourceteams.modules.common.java.io;

import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  下午5:21
 * 功能描述:
 */

public class FileInputStreamTest {

    @Test
    public void testFileCopy() throws IOException {

        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream("/opt/workspace/temp/data/images/hadoop-logo.jpg");

        FileOutputStream fos = new FileOutputStream("/opt/workspace/temp/data/images/hadoop-logo-2.jpg");
        int len = 0;
        while (( len = fis.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        fis.close();
    }




    /**
     * byte 去读,会出现中文乱码问题,切割的问题
     * @throws IOException
     */
    @Test
    public void testRead() throws IOException {

        byte[] buffer = new byte[1024];
        String path = "/opt/workspace/temp/data/44.txt";
        FileInputStream fis = new FileInputStream(path);


        int len = 0;
        while (( len = fis.read(buffer)) != -1){
            System.out.println(new String(buffer,0,len,"GBK"));
        }
        fis.close();
    }

    @Test
    public void testRead_GBK() throws IOException {

        byte[] buffer = new byte[1024];
        String path =  "src/test/resources/file/gbk_file.txt";
        FileInputStream fis = new FileInputStream(path);


        int len = 0;
        while (( len = fis.read(buffer)) != -1){
            System.out.println(new String(buffer,0,len,"GBK"));
        }
        fis.close();
    }

    @Test
    public void c() throws IOException {
        Charset s = Charset.defaultCharset();
        System.out.println(s);

    }
}
