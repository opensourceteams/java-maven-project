package com.opensourceteams.modules.common.java.util.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import java.util.zip.ZipInputStream;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/23  上午5:05
 * 功能描述:
 */

public class URLUtil {

    public static URLConnection openConnection(String urlStr){
        URL url = null;
        try {
            url = new URL(urlStr);
            return url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 得到内容长度
     * @param urlConnection
     * @return
     */
    public static int getContentLength(URLConnection urlConnection){
        if(urlConnection == null){
            return  -1;
        }
        return urlConnection.getContentLength();
    }

    /**
     * 得到内容长度
     * @param urlStr
     * @return
     */
    public static int getContentLength(String urlStr){
        URLConnection urlConnection = openConnection(urlStr) ;
        if(urlConnection == null){
            return  -1;
        }
        return urlConnection.getContentLength();
    }

    /**
     * 得到内容长度
     * @param urlConnection
     * @return
     */
    public static long getContentLengthLong(URLConnection urlConnection){
        if(urlConnection == null){
            return  -1;
        }
        return urlConnection.getContentLengthLong();
    }


    /**
     * 得到内容类型
     * @param urlConnection
     * @return
     */
    public static String getContentType(URLConnection urlConnection){
        if(urlConnection == null){
            return  null;
        }
        return urlConnection.getContentType() ;
    }

    public static byte[] getBytes(String urlStr,int beginIndex,int endIndex) throws Exception {

        URLConnection urlConnection = openConnection(urlStr);
        if(urlConnection == null){
            return  null;
        }else{
            urlConnection.setRequestProperty("Range","bytes="+beginIndex+"-" + (endIndex -1));
            if(urlConnection.getContentLength() <= 0){
                return  null;
            }
        }


        Vector<String> vector = new Vector<String>();
        vector.add("application/octet-stream");
        vector.add("application/zip");


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if(vector.contains(urlConnection.getContentType())){

            byte[] buffer = new byte[1024];
            try {
                InputStream is = urlConnection.getInputStream();
                int len = 0 ;
                   while ((len = is.read(buffer)) != -1){
                        baos.write(buffer,0,len);
                    }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(baos != null){
                    try {
                        baos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            throw new Exception("该文件类型,不支持" + urlConnection.getContentType());
        }


        return baos.toByteArray();
    }
}
