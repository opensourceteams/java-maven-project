package com.opensourceteams.modules.common.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 日期: 2016-03-26  15:25
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class StreamUtil {

    public static void inputSteamToOutputSteam(InputStream is,OutputStream os){
        if(is != null && os != null){
            byte[] buffer = new byte[1024] ;
            int len = 0 ;
            try {
                while ( (len =is.read(buffer)) != -1){
                    os.write(buffer,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(InputStream is){
        if(is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(OutputStream os){
        if(os != null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(InputStream is,OutputStream os){
        if(os != null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
