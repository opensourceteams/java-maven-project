package com.opensourceteams.modules.common.java.util.zip;

import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午6:40
 * 功能描述:
 */

public class ZipUtilTest {

    /**
     * 压缩byte 数组
     */
    @Test
    public void testGzipCompress(){

        byte[] buffer = new byte[1024];
        for(int i =0;i<buffer.length;i++){
            buffer[i] = 10;
        }

        System.out.println("原长度:"+buffer.length);
        byte[] zipBuffer = ZipUtil.gzipCompress(buffer);
        System.out.println("压缩后的长度:" + zipBuffer.length);

    }

    /**
     * 解压byte数组
     */
    @Test
    public void testGzipExtract(){

        byte[] buffer = new byte[1024];
        for(int i =0;i<buffer.length;i++){
            buffer[i] = 10;
        }

        System.out.println("原长度:"+buffer.length);
        byte[] zipBuffer = ZipUtil.gzipCompress(buffer);
        byte[] unzipBuffer = ZipUtil.gZipExtract(zipBuffer);
        System.out.println("压缩后的长度:" + zipBuffer.length);
        System.out.println("解压后的长度:" + unzipBuffer.length);
        for (byte v: unzipBuffer){
            System.out.println("元素:" + v );
        }

    }
}
