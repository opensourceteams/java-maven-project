package com.opensourceteams.modules.common.gramar.zip压缩;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午5:57
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        for(int i =0;i<buffer.length;i++){
            buffer[i] = 10;
        }

        System.out.println("原长度:"+buffer.length);
        byte[] zipBuffer = gzipCompress(buffer);
        System.out.println("压缩后的长度:" + zipBuffer.length);
        byte[] unzipBuffer = gipExtract(zipBuffer);
        System.out.println("解压后:" + unzipBuffer.length);
        for (byte v : unzipBuffer){
            System.out.println("解压后的数据:" + v);
        }


    }

    /**
     * 压缩二进制,从byte 压缩到byte
     * @param data
     * @return
     */
    public static byte[] gzipCompress(byte[] data){

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzos = null;
        try {
             gzos = new GZIPOutputStream(bos);
             gzos.write(data);
             gzos.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bos.toByteArray();
    }

    /**
     * 解压,从byte解压到byte
     * @param data
     * @return
     */
    public static byte[] gipExtract(byte[] data){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        byte[] buffer = new byte[1024];
        try {
            GZIPInputStream gzis = new GZIPInputStream(bis,buffer.length);
            int len = 0 ;


            while ((len = gzis.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            gzis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}
