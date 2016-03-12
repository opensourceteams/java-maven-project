package com.opensourceteams.modeles.common.gramar.文件IO操作.写文件操作;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午9:18
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) throws IOException {

        String path = "/opt/workspace/bigdata/all_frame_intellij/java-maven/b/d.txt";
        write(path,new String[]{"小明","小华"});

    }


    private static void write() throws IOException {
        File file = new File("/opt/workspace/bigdata/all_frame_intellij/java-maven/gbk_file.txt");// 指定要写入的文件

        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 写入信息
        bufferedWriter.write("你好世界");
        bufferedWriter.newLine();// 表示换行
        bufferedWriter.write("hello world");
        bufferedWriter.newLine();// 表示换行
        bufferedWriter.write("liuwen ");
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }

    private static void write(String path,String[] content) throws IOException {
        File file = new File(path);// 指定要写入的文件

        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 写入信息

        for(String s: content){
            bufferedWriter.write(s);
            bufferedWriter.newLine();// 表示换行
        }

        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }
}
