package com.opensourceteams.modules.common.java.io.file;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/16  下午8:31
 * 功能描述:
 */

public class FileBufferedUtil {

    public static String encoded = "UTF-8" ;


    /**
     * BufferedReader 读取流的指定数组 char 数据,默认字符集为UTF-8
     * @param in
     * @param buffer
     * @return
     */
    public static  StringBuilder readerNoEnd(InputStream in,char[] buffer){

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,encoded)) ;

            int len = reader.read(buffer);
            sb.append(buffer,0,len);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return sb;
    }

    /**
     * BufferedReader 读取流的1024 char 数据,默认字符集为UTF-8
     * @param in
     * @return
     */
    public static  StringBuilder readerNoEnd(InputStream in){
        return readerNoEnd(in,new char[1024]);
    }


    /**
     * BufferedReader 读取流的指定大小的内容,默认字符集为UTF-8
     * @param in
     * @param buffer
     * @return
     */
    public static  StringBuilder readerStringBuilderNoClose(BufferedReader reader,InputStream in,char[] buffer){

        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in,encoded)) ;

       /*     String line = reader.readLine();
            sb.append(line);*/

            int len = reader.read(buffer);
            sb.append(buffer,0,len);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    /**
     * BufferedReader 读取流的 1024 char 大小的内容,默认字符集为UTF-8
     * @param in
     * @return
     */
    public static  StringBuilder readerStringBuilderNoClose(BufferedReader reader,InputStream in){
        return readerStringBuilderNoClose(reader,in,new char[1024]);
    }


    public static boolean writerStringNoClose(BufferedWriter writer,OutputStream os,String str){

        try {
            writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            writer.write(str);
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }
}
