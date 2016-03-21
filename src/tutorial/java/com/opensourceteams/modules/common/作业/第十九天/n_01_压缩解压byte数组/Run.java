package com.opensourceteams.modules.common.作业.第十九天.n_01_压缩解压byte数组;

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
        byte[] buffer = new byte[100];
        for(int i =0;i<buffer.length;i++){
            buffer[i] = 10;
        }

        System.out.println("原长度:"+buffer.length);
        byte[] zipBuffer = gzipCompress(buffer);
        System.out.println("压缩后的长度:" + zipBuffer.length);
        byte[] unzipBuffer = gipExtract(zipBuffer);
        System.out.println("解压后:" + unzipBuffer.length);
        for (int i =0 ;i< unzipBuffer.length;i++){
            System.out.println(i +" 解压后的数据:" + unzipBuffer[i]);
        }


    }

    /**
     * 压缩二进制,从byte数组 压缩到byte数组
     * ).压缩运算,压缩包装类 GZIPOutputStream,说明能进行压缩工作
     * ).指定压缩后的输出(ByteArrayOutputStream)
     * ).指定被压缩的数据(参入的被压缩的数据)
     * ).进行压缩处理,从 ByteArrayOutputStream 对象中去取经过压缩处理后的数据
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
     * ).解压的包装类 GZIPInputStream
     * ).解压包类类GZIPInputStream,有一个功能叫read 解压指定大小的数据
     * ).需要包装类ByteArrayInputStream将指定的byte数组转化为输入流
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
