package com.opensourceteams.modules.common.java.util.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  下午6:37
 * 功能描述:
 */

public class ZipUtil {

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
     * 解压,从byte数组解压到byte数组
     * @param data
     * @return
     */
    public static byte[] gZipExtract(byte[] data){
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
