package com.opensourceteams.modules.common.gramar.文件IO操作;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午4:39
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) throws IOException {

        String path = "a.txt";
        writeFile("a.txt");
        List<String> contents = new ArrayList<String>();
        contents.add("中国1");
        contents.add(System.getProperty("line.separator"));
        contents.add("中国2");

        writeFile(path,contents);
        writeFile(path,contents,true);
        appenContent(path,"Aa");

        System.out.println("=======读取文件");
        //readChar(path);

        System.out.println("======读取文件,放到缓存区");
        readCharArray(path);


    }

    /**
     * 读取文件数据到缓冲区
     * @param path
     * @throws IOException
     */
    public  static void readCharArray(String path) throws IOException {
        FileReader fr = new FileReader(path);
        int length = 20; //定义缓冲区的大小
        char[] charArry = new char[length];
        int len =0 ;
        while ((len  = fr.read(charArry,0,length)) != -1) {
            System.out.print(new String(charArry,0,len));
        }

    }


    /**
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
     * 文件的写,会覆盖原来的文件
     * @param path
     * @throws IOException
     */
    public static void writeFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write("中国1");
        writer.write("中国2");
        writer.write(System.getProperty("line.separator"));
        writer.write("中国3");
        writer.close();
    }

    public static void writeFile(String path,List<String> list) throws IOException {
        FileWriter writer = new FileWriter(path);
        for(String s : list){
            writer.write(s);
        }
        writer.close();
    }

    public static void writeFile(String path,List<String> list,boolean appen) throws IOException {
        FileWriter writer = new FileWriter(path,appen);
        for(String s : list){
            writer.write(s);
        }
        writer.close();
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
