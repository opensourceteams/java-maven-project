package com.opensourceteams.modules.common.java.io.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import com.opensourceteams.modules.common.java.array.ArrayUtil;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午5:57
 * 功能描述:
 */

public class FileUtil {

    /*
      * 读字符,一次读一个
      * @param path
      * @throws IOException
      */
    public static void readChar(String path) throws IOException {
        FileReader fr = new FileReader(path);
        int i = 0;
        while ((i =fr.read()) != -1){
            System.out.print((char)i);
        }
        fr.close();
    }



    /**
     * 读取文件数据到缓冲区
     * @param path
     * @throws IOException
     */
    public  static String readCharArray(String path) throws Exception {
        FileReader fr = new FileReader(path);
        int length = 1024; //定义缓冲区的大小
        char[] charArry = new char[length];
        int len =0 ;
        StringBuffer sb = new StringBuffer();
        while ((len  = fr.read(charArry,0,length)) != -1) {
            //System.out.print(new String(charArry,0,len));

            sb.append( ArrayUtil.subArray(charArry,len));
        }
        fr.close();
        return sb.toString();

    }

    /**
     * 写数据到文件中
     * @param path 文件
     * @param list  字符数据
     * @throws IOException
     */
    public static void writeFile(String path,List<String> list) throws IOException {
        FileWriter writer = new FileWriter(path);
        for(String s : list){
            writer.write(s);
        }
        writer.close();
    }

    /**
     * 写数据到文件,可以zhui加
     * @param path
     * @param list
     * @param appen
     * @throws IOException
     */
    public static void writeFile(String path,List<String> list,boolean appen) throws IOException {
        FileWriter writer = new FileWriter(path,appen);
        for(String s : list){
            writer.write(s);
        }
        writer.close();
    }
    public static void writeFileAppend(String path,List<String> list) throws IOException {
        FileWriter writer = new FileWriter(path,true);
        for(String s : list){
            writer.write(s);
        }
        writer.close();
    }


    /**
     * 文件复制,如果文件已存在,就不会fu盖,但是会zhui加内容
     * @param srcPath
     * @param descPath
     * @return
     * @throws Exception
     */
    public  static boolean fileCopyAppend(String srcPath,String descPath) throws Exception {

        FileReader fr = new FileReader(srcPath);
        FileWriter writer = new FileWriter(descPath,true);

        int length = 1024; //定义缓冲区的大小
        char[] charArry = new char[length];
        int len =0 ;
        while ((len  = fr.read(charArry,0,length)) != -1) {
            writer.write(charArry,0,len);
           // writer.write(ArrayUtil.subArray(charArry,len).toString());
        }
        fr.close();
        writer.close();
        return true;

    }

    /**
     * 复制文件,不会zhui加内容
     * @param srcPath
     * @param descPath
     * @return
     * @throws Exception
     */
    public  static boolean fileCopy(String srcPath,String descPath) throws Exception {

        FileReader fr = new FileReader(srcPath);
        FileWriter writer = new FileWriter(descPath,false);

        int length = 1024; //定义缓冲区的大小
        char[] charArry = new char[length];
        int len =0 ;
        while ((len  = fr.read(charArry,0,length)) != -1) {
            writer.write(charArry,0,len);
            // writer.write(ArrayUtil.subArray(charArry,len).toString());
        }
        fr.close();
        writer.close();
        return true;

    }


    public static void appenContent(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
